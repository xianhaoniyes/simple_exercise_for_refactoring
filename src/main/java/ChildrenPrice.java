public class ChildrenPrice extends Price{

    @Override
    public double getCharge(int days) {
        return  days>3? 1.5+ (days-3)*1.5: 1.5;
    }
}
