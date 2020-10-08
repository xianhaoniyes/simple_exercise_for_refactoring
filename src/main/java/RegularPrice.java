public class RegularPrice extends Price {
    @Override
    public double getCharge(int days) {
        return  days>2? 2+ (days-2)*1.5: 2.0;
    }
}
