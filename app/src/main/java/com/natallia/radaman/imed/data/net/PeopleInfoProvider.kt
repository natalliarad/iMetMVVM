package com.natallia.radaman.imed.data.net

import com.natallia.radaman.imed.data.model.People

class PeopleInfoProvider {

    companion object {
        var peopleList = initPeopleList()

        /**
         * Initialises peopleList with dummy data
         */
        private fun initPeopleList(): MutableList<People> {
            var peoples = mutableListOf<People>()
            peoples.add(
                People(
                    "Mark Tremonti",
                    "Alter Bridge",
                    "228-1234567809",
                    "mark@alterbridge.com",
                    "facebook.com/tremonti",
                    "linkedin.com/in/natallia-radaman-111111",
                    1
                )
            )
            peoples.add(
                People(
                    "Jeff Bezos",
                    "Amazon",
                    "206-98765432",
                    "j.bezos@amazon.com",
                    "facebook.com/j.bezos",
                    "linkedin.com/in/natallia-radaman-111111",
                    2
                )
            )
            peoples.add(
                People(
                    "Mark Zuckerberg",
                    "Facebook",
                    "228-12345678",
                    "mark@facebook.com",
                    "facebook.com/mz",
                    "linkedin.com/in/natallia-radaman-111111",
                    3
                )
            )

            peoples.add(
                People(
                    "Sundar Pichai",
                    "Google",
                    "310-98765443221",
                    "s.pichai@gmail.com",
                    "facebook.com/s.pichai",
                    "linkedin.com/in/natallia-radaman-111111",
                    4
                )
            )
            peoples.add(
                People(
                    "Tim Cook",
                    "Apple",
                    "310-1234567889",
                    "cook@apple.com",
                    "facebook.com/t.cook",
                    "linkedin.com/in/natallia-radaman-111111",
                    5
                )
            )
            peoples.add(
                People(
                    "Bil Gates",
                    "Microsoft",
                    "206-9876543221",
                    "gates@microsoft.com",
                    "facebook.com/b.gates",
                    "linkedin.com/in/natallia-radaman-111111",
                    6
                )
            )
            peoples.add(
                People(
                    "Elon Musk",
                    "SpaceX",
                    "310-123456789",
                    "musk@spacex.com",
                    "facebook.com/e.musk",
                    "linkedin.com/in/natallia-radaman-111111",
                    7
                )
            )

            return peoples
        }
    }
}
