package mattsapp.myfavoritecards.service

import mattsapp.myfavoritecards.service.factory.YgoHubServiceFactory

/**
 * Created by Matt on 1/20/2018.
 */
object RestService {
    @JvmField val ygoHub = YgoHubServiceFactory.getYgoHubService()
}