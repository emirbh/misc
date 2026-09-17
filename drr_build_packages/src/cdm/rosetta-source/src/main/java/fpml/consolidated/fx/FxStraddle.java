package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.FxStraddleTypeEnum;
import fpml.consolidated.fx.meta.FxStraddleMeta;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Straddle details. Straddle is composed of two options: a call and a put involving the quotedCurrencyPair.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Straddle details. Straddle is composed of two options: a call and a put involving the quotedCurrencyPair.
 *
 */
@RosettaDataType(value="FxStraddle", builder=FxStraddle.FxStraddleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxStraddle", model="fpml", builder=FxStraddle.FxStraddleBuilderImpl.class, version="2.1.1")
public interface FxStraddle extends RosettaModelObject {

	FxStraddleMeta metaData = new FxStraddleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type Straddle as agreed on the Trade Date, e.g. at the money forward straddle, or delta neutral straddle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type Straddle as agreed on the Trade Date, e.g. at the money forward straddle, or delta neutral straddle.
	 *
	 */
	FxStraddleTypeEnum getStraddleType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A Tenor (time to maturity) of the straddle starting from the Fixing Date (e.g. 1y, 3m)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A Tenor (time to maturity) of the straddle starting from the Fixing Date (e.g. 1y, 3m)
	 *
	 */
	Period getTenorPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for exercising the FxStraddle (underlying options), the underlying options are always European style options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for exercising the FxStraddle (underlying options), the underlying options are always European style options.
	 *
	 */
	FxEuropeanExercise getEuropeanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of parameters defining procedures associated with the exercise.
	 *
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount for the FxStraddle. This will be the notional for the underlying options, which may be exercised by the Buyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount for the FxStraddle. This will be the notional for the underlying options, which may be exercised by the Buyer.
	 *
	 */
	NonNegativeMoney getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The counter currency and amount for the FxStraddle. The Counter Currency Amount is determined using the notional and the Strike Price (which is determined at the fixingTime on the fixingDate).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The counter currency and amount for the FxStraddle. The Counter Currency Amount is determined using the notional and the Strike Price (which is determined at the fixingTime on the fixingDate).
	 *
	 */
	Currency getCounterCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the FX Straddle premium amount, payer and dates. This amount is also determined at the fixingTime on the fixingDate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the FX Straddle premium amount, payer and dates. This amount is also determined at the fixingTime on the fixingDate.
	 *
	 */
	List<? extends FxStraddlePremium> getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. The settlement date is already expressed by europeanExercise/valueDate. The Settlement Date for the FxStraddle (if exercised at the expiryTime on the expiry Date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. The settlement date is already expressed by europeanExercise/valueDate. The Settlement Date for the FxStraddle (if exercised at the expiryTime on the expiry Date).
	 *
	 */
	AdjustableOrAdjustedDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the settlement type for the FxStraddle. If deliverable then this element is removed. If non-deliverable, then the In-The-Money amount of the relevant option within the FxStraddle is paid by the Seller to the Buyer. The In-The-Money amount is calculated using the parameters within this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the settlement type for the FxStraddle. If deliverable then this element is removed. If non-deliverable, then the In-The-Money amount of the relevant option within the FxStraddle is paid by the Seller to the Buyer. The In-The-Money amount is calculated using the parameters within this element.
	 *
	 */
	FxCashSettlementSimple getCashSettlement();

	/*********************** Build Methods  ***********************/
	FxStraddle build();
	
	FxStraddle.FxStraddleBuilder toBuilder();
	
	static FxStraddle.FxStraddleBuilder builder() {
		return new FxStraddle.FxStraddleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStraddle> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxStraddle> getType() {
		return FxStraddle.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("straddleType"), FxStraddleTypeEnum.class, getStraddleType(), this);
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
		processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.class, getNotional());
		processRosetta(path.newSubPath("counterCurrency"), processor, Currency.class, getCounterCurrency());
		processRosetta(path.newSubPath("premium"), processor, FxStraddlePremium.class, getPremium());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.class, getSettlementDate());
		processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.class, getCashSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStraddleBuilder extends FxStraddle, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenorPeriod();
		@Override
		Period.PeriodBuilder getTenorPeriod();
		FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		@Override
		FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		@Override
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getNotional();
		Currency.CurrencyBuilder getOrCreateCounterCurrency();
		@Override
		Currency.CurrencyBuilder getCounterCurrency();
		FxStraddlePremium.FxStraddlePremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends FxStraddlePremium.FxStraddlePremiumBuilder> getPremium();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate();
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement();
		@Override
		FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement();
		FxStraddle.FxStraddleBuilder setStraddleType(FxStraddleTypeEnum straddleType);
		FxStraddle.FxStraddleBuilder setTenorPeriod(Period tenorPeriod);
		FxStraddle.FxStraddleBuilder setEuropeanExercise(FxEuropeanExercise europeanExercise);
		FxStraddle.FxStraddleBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		FxStraddle.FxStraddleBuilder setNotional(NonNegativeMoney notional);
		FxStraddle.FxStraddleBuilder setCounterCurrency(Currency counterCurrency);
		FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium);
		FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium premium, int idx);
		FxStraddle.FxStraddleBuilder addPremium(List<? extends FxStraddlePremium> premium);
		FxStraddle.FxStraddleBuilder setPremium(List<? extends FxStraddlePremium> premium);
		FxStraddle.FxStraddleBuilder setSettlementDate(AdjustableOrAdjustedDate settlementDate);
		FxStraddle.FxStraddleBuilder setCashSettlement(FxCashSettlementSimple cashSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("straddleType"), FxStraddleTypeEnum.class, getStraddleType(), this);
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
			processRosetta(path.newSubPath("europeanExercise"), processor, FxEuropeanExercise.FxEuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("notional"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getNotional());
			processRosetta(path.newSubPath("counterCurrency"), processor, Currency.CurrencyBuilder.class, getCounterCurrency());
			processRosetta(path.newSubPath("premium"), processor, FxStraddlePremium.FxStraddlePremiumBuilder.class, getPremium());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("cashSettlement"), processor, FxCashSettlementSimple.FxCashSettlementSimpleBuilder.class, getCashSettlement());
		}
		

		FxStraddle.FxStraddleBuilder prune();
	}

	/*********************** Immutable Implementation of FxStraddle  ***********************/
	class FxStraddleImpl implements FxStraddle {
		private final FxStraddleTypeEnum straddleType;
		private final Period tenorPeriod;
		private final FxEuropeanExercise europeanExercise;
		private final ExerciseProcedure exerciseProcedure;
		private final NonNegativeMoney notional;
		private final Currency counterCurrency;
		private final List<? extends FxStraddlePremium> premium;
		private final AdjustableOrAdjustedDate settlementDate;
		private final FxCashSettlementSimple cashSettlement;
		
		protected FxStraddleImpl(FxStraddle.FxStraddleBuilder builder) {
			this.straddleType = builder.getStraddleType();
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.counterCurrency = ofNullable(builder.getCounterCurrency()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("straddleType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("straddleType")
		public FxStraddleTypeEnum getStraddleType() {
			return straddleType;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("europeanExercise")
		public FxEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notional")
		public NonNegativeMoney getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("counterCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterCurrency")
		public Currency getCounterCurrency() {
			return counterCurrency;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxStraddlePremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxStraddle build() {
			return this;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder toBuilder() {
			FxStraddle.FxStraddleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStraddle.FxStraddleBuilder builder) {
			ofNullable(getStraddleType()).ifPresent(builder::setStraddleType);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getCounterCurrency()).ifPresent(builder::setCounterCurrency);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStraddle _that = getType().cast(o);
		
			if (!Objects.equals(straddleType, _that.getStraddleType())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(counterCurrency, _that.getCounterCurrency())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (straddleType != null ? straddleType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (counterCurrency != null ? counterCurrency.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddle {" +
				"straddleType=" + this.straddleType + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"notional=" + this.notional + ", " +
				"counterCurrency=" + this.counterCurrency + ", " +
				"premium=" + this.premium + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}';
		}
	}

	/*********************** Builder Implementation of FxStraddle  ***********************/
	class FxStraddleBuilderImpl implements FxStraddle.FxStraddleBuilder {
	
		protected FxStraddleTypeEnum straddleType;
		protected Period.PeriodBuilder tenorPeriod;
		protected FxEuropeanExercise.FxEuropeanExerciseBuilder europeanExercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected NonNegativeMoney.NonNegativeMoneyBuilder notional;
		protected Currency.CurrencyBuilder counterCurrency;
		protected List<FxStraddlePremium.FxStraddlePremiumBuilder> premium = new ArrayList<>();
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder settlementDate;
		protected FxCashSettlementSimple.FxCashSettlementSimpleBuilder cashSettlement;
		
		@Override
		@RosettaAttribute("straddleType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("straddleType")
		public FxStraddleTypeEnum getStraddleType() {
			return straddleType;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("europeanExercise")
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = FxEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notional")
		public NonNegativeMoney.NonNegativeMoneyBuilder getNotional() {
			return notional;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateNotional() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterCurrency")
		public Currency.CurrencyBuilder getCounterCurrency() {
			return counterCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCounterCurrency() {
			Currency.CurrencyBuilder result;
			if (counterCurrency!=null) {
				result = counterCurrency;
			}
			else {
				result = counterCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends FxStraddlePremium.FxStraddlePremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						FxStraddlePremium.FxStraddlePremiumBuilder newPremium = FxStraddlePremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateSettlementDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public FxCashSettlementSimple.FxCashSettlementSimpleBuilder getOrCreateCashSettlement() {
			FxCashSettlementSimple.FxCashSettlementSimpleBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = FxCashSettlementSimple.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("straddleType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("straddleType")
		@Override
		public FxStraddle.FxStraddleBuilder setStraddleType(FxStraddleTypeEnum _straddleType) {
			this.straddleType = _straddleType == null ? null : _straddleType;
			return this;
		}
		
		@RosettaAttribute("tenorPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tenorPeriod")
		@Override
		public FxStraddle.FxStraddleBuilder setTenorPeriod(Period _tenorPeriod) {
			this.tenorPeriod = _tenorPeriod == null ? null : _tenorPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("europeanExercise")
		@Override
		public FxStraddle.FxStraddleBuilder setEuropeanExercise(FxEuropeanExercise _europeanExercise) {
			this.europeanExercise = _europeanExercise == null ? null : _europeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseProcedure")
		@Override
		public FxStraddle.FxStraddleBuilder setExerciseProcedure(ExerciseProcedure _exerciseProcedure) {
			this.exerciseProcedure = _exerciseProcedure == null ? null : _exerciseProcedure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notional")
		@Override
		public FxStraddle.FxStraddleBuilder setNotional(NonNegativeMoney _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterCurrency")
		@Override
		public FxStraddle.FxStraddleBuilder setCounterCurrency(Currency _counterCurrency) {
			this.counterCurrency = _counterCurrency == null ? null : _counterCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder addPremium(FxStraddlePremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder addPremium(List<? extends FxStraddlePremium> premiums) {
			if (premiums != null) {
				for (final FxStraddlePremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public FxStraddle.FxStraddleBuilder setPremium(List<? extends FxStraddlePremium> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public FxStraddle.FxStraddleBuilder setSettlementDate(AdjustableOrAdjustedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public FxStraddle.FxStraddleBuilder setCashSettlement(FxCashSettlementSimple _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxStraddle build() {
			return new FxStraddle.FxStraddleImpl(this);
		}
		
		@Override
		public FxStraddle.FxStraddleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddle.FxStraddleBuilder prune() {
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (counterCurrency!=null && !counterCurrency.prune().hasData()) counterCurrency = null;
			premium = premium.stream().filter(b->b!=null).<FxStraddlePremium.FxStraddlePremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStraddleType()!=null) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getCounterCurrency()!=null && getCounterCurrency().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddle.FxStraddleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxStraddle.FxStraddleBuilder o = (FxStraddle.FxStraddleBuilder) other;
			
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getCounterCurrency(), o.getCounterCurrency(), this::setCounterCurrency);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			
			merger.mergeBasic(getStraddleType(), o.getStraddleType(), this::setStraddleType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxStraddle _that = getType().cast(o);
		
			if (!Objects.equals(straddleType, _that.getStraddleType())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(counterCurrency, _that.getCounterCurrency())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (straddleType != null ? straddleType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (counterCurrency != null ? counterCurrency.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddleBuilder {" +
				"straddleType=" + this.straddleType + ", " +
				"tenorPeriod=" + this.tenorPeriod + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"notional=" + this.notional + ", " +
				"counterCurrency=" + this.counterCurrency + ", " +
				"premium=" + this.premium + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"cashSettlement=" + this.cashSettlement +
			'}';
		}
	}
}
