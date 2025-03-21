import controller.DesignerController;
import controller.DeveloperController;
import exceptions.emptyException;
import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import model.DesignerRepository;
import model.DeveloperRepository;
import view.DesignerView;
import view.DeveloperView;


public class Main {
    public static void main(String[] args) throws UserNotFound, IsEmptyException, UserAlreadyCreated, emptyException {
        DeveloperRepository developerRepository = new DeveloperRepository();
        DeveloperView developerView = new DeveloperView(new DeveloperController(developerRepository));
        DesignerRepository designerRepository = new DesignerRepository();
        DesignerView designerView = new DesignerView(new DesignerController(designerRepository));

        App.__init(developerView,designerView);
    }
}
