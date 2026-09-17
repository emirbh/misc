package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.com.meta.CommodityExerciseMeta;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The parameters for defining how the commodity option can be exercised, how it is priced and how it is settled.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The parameters for defining how the commodity option can be exercised, how it is priced and how it is settled.
 *
 */
@RosettaDataType(value="CommodityExercise", builder=CommodityExercise.CommodityExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityExercise", model="fpml", builder=CommodityExercise.CommodityExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityExercise extends RosettaModelObject {

	CommodityExerciseMeta metaData = new CommodityExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the expiration date for an American option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the expiration date for an American option.
	 *
	 */
	CommodityAmericanExercise getAmericanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European or Asian style option. For an Asian style option the expiration date is equivalent to the termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European or Asian style option. For an Asian style option the expiration date is equivalent to the termination date.
	 *
	 */
	CommodityEuropeanExercise getEuropeanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 *
	 */
	Boolean getAutomaticExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 *
	 */
	Boolean getWrittenConfirmation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency into which the Commodity Option Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted, then an FX determination method should also be specified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency into which the Commodity Option Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted, then an FX determination method should also be specified.
	 *
	 */
	IdentifiedCurrency getSettlementCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 *
	 */
	CommodityFx getFx();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 */
	BigDecimal getConversionFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 */
	Boolean getMasterAgreementPaymentDates();

	/*********************** Build Methods  ***********************/
	CommodityExercise build();
	
	CommodityExercise.CommodityExerciseBuilder toBuilder();
	
	static CommodityExercise.CommodityExerciseBuilder builder() {
		return new CommodityExercise.CommodityExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityExercise> getType() {
		return CommodityExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.class, getEuropeanExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityExerciseBuilder extends CommodityExercise, RosettaModelObjectBuilder {
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise();
		@Override
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		@Override
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		@Override
		CommodityFx.CommodityFxBuilder getFx();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		@Override
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		CommodityExercise.CommodityExerciseBuilder setAmericanExercise(CommodityAmericanExercise americanExercise);
		CommodityExercise.CommodityExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise);
		CommodityExercise.CommodityExerciseBuilder setAutomaticExercise(Boolean automaticExercise);
		CommodityExercise.CommodityExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation);
		CommodityExercise.CommodityExerciseBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommodityExercise.CommodityExerciseBuilder setFx(CommodityFx fx);
		CommodityExercise.CommodityExerciseBuilder setConversionFactor(BigDecimal conversionFactor);
		CommodityExercise.CommodityExerciseBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		CommodityExercise.CommodityExerciseBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		CommodityExercise.CommodityExerciseBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.CommodityAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder.class, getEuropeanExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		}
		

		CommodityExercise.CommodityExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityExercise  ***********************/
	class CommodityExerciseImpl implements CommodityExercise {
		private final CommodityAmericanExercise americanExercise;
		private final CommodityEuropeanExercise europeanExercise;
		private final Boolean automaticExercise;
		private final Boolean writtenConfirmation;
		private final IdentifiedCurrency settlementCurrency;
		private final CommodityFx fx;
		private final BigDecimal conversionFactor;
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		
		protected CommodityExerciseImpl(CommodityExercise.CommodityExerciseBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.writtenConfirmation = builder.getWrittenConfirmation();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public CommodityAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public CommodityEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public IdentifiedCurrency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		public CommodityExercise build() {
			return this;
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder toBuilder() {
			CommodityExercise.CommodityExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityExercise.CommodityExerciseBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getWrittenConfirmation()).ifPresent(builder::setWrittenConfirmation);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getFx()).ifPresent(builder::setFx);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExercise {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityExercise  ***********************/
	class CommodityExerciseBuilderImpl implements CommodityExercise.CommodityExerciseBuilder {
	
		protected CommodityAmericanExercise.CommodityAmericanExerciseBuilder americanExercise;
		protected CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder europeanExercise;
		protected Boolean automaticExercise;
		protected Boolean writtenConfirmation;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected CommodityFx.CommodityFxBuilder fx;
		protected BigDecimal conversionFactor;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise() {
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = CommodityAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = CommodityEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fx")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("americanExercise")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setAmericanExercise(CommodityAmericanExercise _americanExercise) {
			this.americanExercise = _americanExercise == null ? null : _americanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("europeanExercise")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise _europeanExercise) {
			this.europeanExercise = _europeanExercise == null ? null : _europeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("automaticExercise")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setAutomaticExercise(Boolean _automaticExercise) {
			this.automaticExercise = _automaticExercise == null ? null : _automaticExercise;
			return this;
		}
		
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("writtenConfirmation")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setWrittenConfirmation(Boolean _writtenConfirmation) {
			this.writtenConfirmation = _writtenConfirmation == null ? null : _writtenConfirmation;
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setSettlementCurrency(IdentifiedCurrency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fx")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fx")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setFx(CommodityFx _fx) {
			this.fx = _fx == null ? null : _fx.toBuilder();
			return this;
		}
		
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conversionFactor")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public CommodityExercise.CommodityExerciseBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@Override
		public CommodityExercise build() {
			return new CommodityExercise.CommodityExerciseImpl(this);
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercise.CommodityExerciseBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (fx!=null && !fx.prune().hasData()) fx = null;
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getAutomaticExercise()!=null) return true;
			if (getWrittenConfirmation()!=null) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getFx()!=null && getFx().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercise.CommodityExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityExercise.CommodityExerciseBuilder o = (CommodityExercise.CommodityExerciseBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getWrittenConfirmation(), o.getWrittenConfirmation(), this::setWrittenConfirmation);
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExerciseBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}
}
