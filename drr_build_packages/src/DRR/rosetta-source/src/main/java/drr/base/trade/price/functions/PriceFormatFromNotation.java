package drr.base.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.standards.iso.functions.FormatToBaseOne18Rate;
import drr.standards.iso.functions.FormatToBaseOneRate;
import drr.standards.iso.functions.FormatToMax5Number;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceFormatFromNotation.PriceFormatFromNotationDefault.class)
public abstract class PriceFormatFromNotation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToBaseOne18Rate formatToBaseOne18Rate;
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;
	@Inject protected FormatToMax5Number formatToMax5Number;
	@Inject protected MultiplyPrice multiplyPrice;

	/**
	* @param price 
	* @param notation 
	* @return priceFormat 
	*/
	public PriceFormat evaluate(BigDecimal price, PriceNotationEnum notation) {
		PriceFormat.PriceFormatBuilder priceFormatBuilder = doEvaluate(price, notation);
		
		final PriceFormat priceFormat;
		if (priceFormatBuilder == null) {
			priceFormat = null;
		} else {
			priceFormat = priceFormatBuilder.build();
			objectValidator.validate(PriceFormat.class, priceFormat);
		}
		
		return priceFormat;
	}

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(BigDecimal price, PriceNotationEnum notation);

	public static class PriceFormatFromNotationDefault extends PriceFormatFromNotation {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(BigDecimal price, PriceNotationEnum notation) {
			PriceFormat.PriceFormatBuilder priceFormat = PriceFormat.builder();
			return assignOutput(priceFormat, price, notation);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder priceFormat, BigDecimal price, PriceNotationEnum notation) {
			final MapperS<BigDecimal> thenArg0;
			if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				thenArg0 = MapperS.of(multiplyPrice.evaluate(price, PriceNotationEnum.MONETARY));
			} else {
				thenArg0 = MapperS.<BigDecimal>ofNull();
			}
			final MapperS<BigDecimal> thenArg1;
			if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				thenArg1 = MapperS.of(multiplyPrice.evaluate(price, PriceNotationEnum.DECIMAL));
			} else {
				thenArg1 = MapperS.<BigDecimal>ofNull();
			}
			final MapperS<BigDecimal> thenArg2;
			if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				thenArg2 = MapperS.of(multiplyPrice.evaluate(price, PriceNotationEnum.PERCENTAGE));
			} else {
				thenArg2 = MapperS.<BigDecimal>ofNull();
			}
			final MapperS<BigDecimal> thenArg3;
			if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
				thenArg3 = MapperS.of(multiplyPrice.evaluate(price, PriceNotationEnum.BASIS));
			} else {
				thenArg3 = MapperS.<BigDecimal>ofNull();
			}
			priceFormat = toBuilder(PriceFormat.builder()
				.setMonetary(MapperS.of(formatToBaseOne18Rate.evaluate(thenArg0.get())).get())
				.setDecimal(MapperS.of(formatToBaseOneRate.evaluate(thenArg1.get())).get())
				.setPercentage(MapperS.of(formatToBaseOneRate.evaluate(thenArg2.get())).get())
				.setBasis(MapperS.of(formatToMax5Number.evaluate(thenArg3.get())).get())
				.build());
			
			return Optional.ofNullable(priceFormat)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
