package uni.pu.fmi.bookrating;

import io.cucumber.java.en.When;

public class StarsStep
{
    private final StarModel starModel;

    public StarsStep(StarModel starModel)
    {
        this.starModel = starModel;
    }


    @When("избере {int} звезди")
    public void selectStarts(Integer stars)
    {
        this.starModel.setStars(stars);
    }
}
