<template>
    <div class="mx-accordion-two">
        <b-card no-body>
            <b-card-header header-tag="header">
                <b-button block v-b-toggle.accordion-1 class="acc-btn border-0 text-left">
                    How can we help?
                </b-button>
            </b-card-header>
            <b-collapse id="accordion-1" visible accordion="my-accordion">
                <b-card-body>
                    <b-card-text>
                        MaxCoach supports the act of teaching and learning on multiple platforms like online or offline via material downloads. We know things aren’t supposed to be devoured in a short time, you can always access our knowledge base from any device.
                    </b-card-text>
                </b-card-body>
            </b-collapse>
        </b-card>
        <b-card no-body>
            <b-card-header header-tag="header">
                <b-button block v-b-toggle.accordion-2 class="acc-btn border-0 text-left">
                    Why would I need a business coach?
                </b-button>
            </b-card-header>
            <b-collapse id="accordion-2" visible accordion="my-accordion">
                <b-card-body>
                    <b-card-text>
                        Study for a number of courses at the same time is possible as long as you can afford the fee and time for completing them in the proper time. Learn at your own desired timeline and timetable. Maximum up to 5 course at a time for a learner at MaxCoach.
                    </b-card-text>
                </b-card-body>
            </b-collapse>
        </b-card>
        <b-card no-body>
            <b-card-header header-tag="header">
                <b-button block v-b-toggle.accordion-3 class="acc-btn border-0 text-left">
                    What is one-on-one coaching?
                </b-button>
            </b-card-header>
            <b-collapse id="accordion-3" visible accordion="my-accordion">
                <b-card-body>
                    <b-card-text>
                        It’s not just a normal thing to be able to build such a solid online educational system like MaxCoach where your progress is easily tracked and feedback is properly delivered. We promise to keep improving our system for better stability and flexibility.
                    </b-card-text>
                </b-card-body>
            </b-collapse>
        </b-card>
    </div>
</template>