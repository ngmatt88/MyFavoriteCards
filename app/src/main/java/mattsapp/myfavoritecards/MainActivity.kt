package mattsapp.myfavoritecards

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mattsapp.myfavoritecards.service.RestService
import android.widget.Toast
import android.R.attr.data
import org.reactivestreams.Subscription
import org.reactivestreams.Subscriber



class MainActivity : AppCompatActivity() {
    val myFavoriteCards = arrayListOf("Dark Magician", "Scarm, Malebranche of the Burning Abyss", "Blue-Eyes White Dragon", "Master Peace, the True Dracoslaying King")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getMyFavoriteCards(){

        for(card in myFavoriteCards){
            RestService.ygoHub.getCardInfo(card)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Subscriber<VsResponseAdapter.VsResponse<Session>> {
                        override fun onSubscribe(s: Subscription) {
                            //the below is necessary for the flowable to emit the item
                            s.request(java.lang.Long.MAX_VALUE)
                        }

                        override fun onNext(sdkSession: VsResponseAdapter.VsResponse<Session>) {
                            Toast.makeText(getContext(), "Session started with Id :  " + sdkSession.data.getId() + " player id " + sdkSession.data.getPlayerId(), Toast.LENGTH_SHORT).show()
                            add to adapter
                        }

                        override fun onError(t: Throwable) {
                            Log.w(javaClass.simpleName, t.message)
                            Toast.makeText(getContext(),
                                    "Sorry an error occurred, please try again",
                                    Toast.LENGTH_SHORT).show()
                        }

                        override fun onComplete() {
                        }
                    })
        }

    }
}
