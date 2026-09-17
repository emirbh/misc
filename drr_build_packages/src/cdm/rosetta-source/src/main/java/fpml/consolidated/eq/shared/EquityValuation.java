package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.EquityValuationMeta;
import fpml.consolidated.fpmlenum.FPVFinalPriceElectionFallbackEnum;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining how and when an equity option is to be valued.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining how and when an equity option is to be valued.
 *
 */
@RosettaDataType(value="EquityValuation", builder=EquityValuation.EquityValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityValuation", model="fpml", builder=EquityValuation.EquityValuationBuilderImpl.class, version="2.1.1")
public interface EquityValuation extends RosettaModelObject {

	EquityValuationMeta metaData = new EquityValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The term "Valuation Date" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Cash Settlement Payment Date in accordance with the ISDA 2002 Equity Derivatives Definitions. SettlementCycle in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The term "Valuation Date" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Cash Settlement Payment Date in accordance with the ISDA 2002 Equity Derivatives Definitions. SettlementCycle in accordance with the ISDA 2011 Equity Derivatives Definitions.
	 *
	 */
	AdjustableDateOrRelativeDateSequence getValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the interim equity valuation dates of a swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the interim equity valuation dates of a swap.
	 *
	 */
	AdjustableRelativeOrPeriodicDates getValuationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
	 *
	 */
	TimeTypeEnum getValuationTimeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location – e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location – e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
	 *
	 */
	BusinessCenterTime getValuationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 *
	 */
	Boolean getFuturesPriceValuation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
	 *
	 */
	Boolean getOptionsPriceValuation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of valuation dates between valuation start date and valuation end date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of valuation dates between valuation start date and valuation end date.
	 *
	 */
	Integer getNumberOfValuationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the dividend valuation dates of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the dividend valuation dates of the swap.
	 *
	 */
	AdjustableRelativeOrPeriodicDates getDividendValuationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
	 *
	 */
	FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback();

	/*********************** Build Methods  ***********************/
	EquityValuation build();
	
	EquityValuation.EquityValuationBuilder toBuilder();
	
	static EquityValuation.EquityValuationBuilder builder() {
		return new EquityValuation.EquityValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityValuation> getType() {
		return EquityValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustableDateOrRelativeDateSequence.class, getValuationDate());
		processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getValuationDates());
		processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
		processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.class, getValuationTime());
		processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
		processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
		processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
		processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getDividendValuationDates());
		processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityValuationBuilder extends EquityValuation, RosettaModelObjectBuilder {
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getOrCreateValuationDate();
		@Override
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getValuationDate();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates();
		EquityValuation.EquityValuationBuilder setId(String id);
		EquityValuation.EquityValuationBuilder setValuationDate(AdjustableDateOrRelativeDateSequence valuationDate);
		EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates valuationDates);
		EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum valuationTimeType);
		EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime valuationTime);
		EquityValuation.EquityValuationBuilder setFuturesPriceValuation(Boolean futuresPriceValuation);
		EquityValuation.EquityValuationBuilder setOptionsPriceValuation(Boolean optionsPriceValuation);
		EquityValuation.EquityValuationBuilder setNumberOfValuationDates(Integer numberOfValuationDates);
		EquityValuation.EquityValuationBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates dividendValuationDates);
		EquityValuation.EquityValuationBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("valuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getValuationDates());
			processor.processBasic(path.newSubPath("valuationTimeType"), TimeTypeEnum.class, getValuationTimeType(), this);
			processRosetta(path.newSubPath("valuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getValuationTime());
			processor.processBasic(path.newSubPath("futuresPriceValuation"), Boolean.class, getFuturesPriceValuation(), this);
			processor.processBasic(path.newSubPath("optionsPriceValuation"), Boolean.class, getOptionsPriceValuation(), this);
			processor.processBasic(path.newSubPath("numberOfValuationDates"), Integer.class, getNumberOfValuationDates(), this);
			processRosetta(path.newSubPath("dividendValuationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getDividendValuationDates());
			processor.processBasic(path.newSubPath("fPVFinalPriceElectionFallback"), FPVFinalPriceElectionFallbackEnum.class, getFPVFinalPriceElectionFallback(), this);
		}
		

		EquityValuation.EquityValuationBuilder prune();
	}

	/*********************** Immutable Implementation of EquityValuation  ***********************/
	class EquityValuationImpl implements EquityValuation {
		private final String id;
		private final AdjustableDateOrRelativeDateSequence valuationDate;
		private final AdjustableRelativeOrPeriodicDates valuationDates;
		private final TimeTypeEnum valuationTimeType;
		private final BusinessCenterTime valuationTime;
		private final Boolean futuresPriceValuation;
		private final Boolean optionsPriceValuation;
		private final Integer numberOfValuationDates;
		private final AdjustableRelativeOrPeriodicDates dividendValuationDates;
		private final FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		
		protected EquityValuationImpl(EquityValuation.EquityValuationBuilder builder) {
			this.id = builder.getId();
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.valuationDates = ofNullable(builder.getValuationDates()).map(f->f.build()).orElse(null);
			this.valuationTimeType = builder.getValuationTimeType();
			this.valuationTime = ofNullable(builder.getValuationTime()).map(f->f.build()).orElse(null);
			this.futuresPriceValuation = builder.getFuturesPriceValuation();
			this.optionsPriceValuation = builder.getOptionsPriceValuation();
			this.numberOfValuationDates = builder.getNumberOfValuationDates();
			this.dividendValuationDates = ofNullable(builder.getDividendValuationDates()).map(f->f.build()).orElse(null);
			this.fPVFinalPriceElectionFallback = builder.getFPVFinalPriceElectionFallback();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustableDateOrRelativeDateSequence getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDates")
		public AdjustableRelativeOrPeriodicDates getValuationDates() {
			return valuationDates;
		}
		
		@Override
		@RosettaAttribute("valuationTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTimeType")
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTime")
		public BusinessCenterTime getValuationTime() {
			return valuationTime;
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@Override
		public EquityValuation build() {
			return this;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			EquityValuation.EquityValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityValuation.EquityValuationBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getValuationDates()).ifPresent(builder::setValuationDates);
			ofNullable(getValuationTimeType()).ifPresent(builder::setValuationTimeType);
			ofNullable(getValuationTime()).ifPresent(builder::setValuationTime);
			ofNullable(getFuturesPriceValuation()).ifPresent(builder::setFuturesPriceValuation);
			ofNullable(getOptionsPriceValuation()).ifPresent(builder::setOptionsPriceValuation);
			ofNullable(getNumberOfValuationDates()).ifPresent(builder::setNumberOfValuationDates);
			ofNullable(getDividendValuationDates()).ifPresent(builder::setDividendValuationDates);
			ofNullable(getFPVFinalPriceElectionFallback()).ifPresent(builder::setFPVFinalPriceElectionFallback);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuation {" +
				"id=" + this.id + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTimeType=" + this.valuationTimeType + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityValuation  ***********************/
	class EquityValuationBuilderImpl implements EquityValuation.EquityValuationBuilder {
	
		protected String id;
		protected AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder valuationDate;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder valuationDates;
		protected TimeTypeEnum valuationTimeType;
		protected BusinessCenterTime.BusinessCenterTimeBuilder valuationTime;
		protected Boolean futuresPriceValuation;
		protected Boolean optionsPriceValuation;
		protected Integer numberOfValuationDates;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder dividendValuationDates;
		protected FPVFinalPriceElectionFallbackEnum fPVFinalPriceElectionFallback;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder getOrCreateValuationDate() {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustableDateOrRelativeDateSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getValuationDates() {
			return valuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (valuationDates!=null) {
				result = valuationDates;
			}
			else {
				result = valuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTimeType")
		public TimeTypeEnum getValuationTimeType() {
			return valuationTimeType;
		}
		
		@Override
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getValuationTime() {
			return valuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (valuationTime!=null) {
				result = valuationTime;
			}
			else {
				result = valuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("futuresPriceValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futuresPriceValuation")
		public Boolean getFuturesPriceValuation() {
			return futuresPriceValuation;
		}
		
		@Override
		@RosettaAttribute("optionsPriceValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsPriceValuation")
		public Boolean getOptionsPriceValuation() {
			return optionsPriceValuation;
		}
		
		@Override
		@RosettaAttribute("numberOfValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfValuationDates")
		public Integer getNumberOfValuationDates() {
			return numberOfValuationDates;
		}
		
		@Override
		@RosettaAttribute("dividendValuationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendValuationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getDividendValuationDates() {
			return dividendValuationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateDividendValuationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (dividendValuationDates!=null) {
				result = dividendValuationDates;
			}
			else {
				result = dividendValuationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fPVFinalPriceElectionFallback")
		public FPVFinalPriceElectionFallbackEnum getFPVFinalPriceElectionFallback() {
			return fPVFinalPriceElectionFallback;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityValuation.EquityValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public EquityValuation.EquityValuationBuilder setValuationDate(AdjustableDateOrRelativeDateSequence _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDates")
		@Override
		public EquityValuation.EquityValuationBuilder setValuationDates(AdjustableRelativeOrPeriodicDates _valuationDates) {
			this.valuationDates = _valuationDates == null ? null : _valuationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationTimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimeType")
		@Override
		public EquityValuation.EquityValuationBuilder setValuationTimeType(TimeTypeEnum _valuationTimeType) {
			this.valuationTimeType = _valuationTimeType == null ? null : _valuationTimeType;
			return this;
		}
		
		@RosettaAttribute("valuationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTime")
		@Override
		public EquityValuation.EquityValuationBuilder setValuationTime(BusinessCenterTime _valuationTime) {
			this.valuationTime = _valuationTime == null ? null : _valuationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("futuresPriceValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("futuresPriceValuation")
		@Override
		public EquityValuation.EquityValuationBuilder setFuturesPriceValuation(Boolean _futuresPriceValuation) {
			this.futuresPriceValuation = _futuresPriceValuation == null ? null : _futuresPriceValuation;
			return this;
		}
		
		@RosettaAttribute("optionsPriceValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsPriceValuation")
		@Override
		public EquityValuation.EquityValuationBuilder setOptionsPriceValuation(Boolean _optionsPriceValuation) {
			this.optionsPriceValuation = _optionsPriceValuation == null ? null : _optionsPriceValuation;
			return this;
		}
		
		@RosettaAttribute("numberOfValuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfValuationDates")
		@Override
		public EquityValuation.EquityValuationBuilder setNumberOfValuationDates(Integer _numberOfValuationDates) {
			this.numberOfValuationDates = _numberOfValuationDates == null ? null : _numberOfValuationDates;
			return this;
		}
		
		@RosettaAttribute("dividendValuationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendValuationDates")
		@Override
		public EquityValuation.EquityValuationBuilder setDividendValuationDates(AdjustableRelativeOrPeriodicDates _dividendValuationDates) {
			this.dividendValuationDates = _dividendValuationDates == null ? null : _dividendValuationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fPVFinalPriceElectionFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fPVFinalPriceElectionFallback")
		@Override
		public EquityValuation.EquityValuationBuilder setFPVFinalPriceElectionFallback(FPVFinalPriceElectionFallbackEnum _fPVFinalPriceElectionFallback) {
			this.fPVFinalPriceElectionFallback = _fPVFinalPriceElectionFallback == null ? null : _fPVFinalPriceElectionFallback;
			return this;
		}
		
		@Override
		public EquityValuation build() {
			return new EquityValuation.EquityValuationImpl(this);
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder prune() {
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (valuationDates!=null && !valuationDates.prune().hasData()) valuationDates = null;
			if (valuationTime!=null && !valuationTime.prune().hasData()) valuationTime = null;
			if (dividendValuationDates!=null && !dividendValuationDates.prune().hasData()) dividendValuationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getValuationDates()!=null && getValuationDates().hasData()) return true;
			if (getValuationTimeType()!=null) return true;
			if (getValuationTime()!=null && getValuationTime().hasData()) return true;
			if (getFuturesPriceValuation()!=null) return true;
			if (getOptionsPriceValuation()!=null) return true;
			if (getNumberOfValuationDates()!=null) return true;
			if (getDividendValuationDates()!=null && getDividendValuationDates().hasData()) return true;
			if (getFPVFinalPriceElectionFallback()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityValuation.EquityValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityValuation.EquityValuationBuilder o = (EquityValuation.EquityValuationBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getValuationDates(), o.getValuationDates(), this::setValuationDates);
			merger.mergeRosetta(getValuationTime(), o.getValuationTime(), this::setValuationTime);
			merger.mergeRosetta(getDividendValuationDates(), o.getDividendValuationDates(), this::setDividendValuationDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getValuationTimeType(), o.getValuationTimeType(), this::setValuationTimeType);
			merger.mergeBasic(getFuturesPriceValuation(), o.getFuturesPriceValuation(), this::setFuturesPriceValuation);
			merger.mergeBasic(getOptionsPriceValuation(), o.getOptionsPriceValuation(), this::setOptionsPriceValuation);
			merger.mergeBasic(getNumberOfValuationDates(), o.getNumberOfValuationDates(), this::setNumberOfValuationDates);
			merger.mergeBasic(getFPVFinalPriceElectionFallback(), o.getFPVFinalPriceElectionFallback(), this::setFPVFinalPriceElectionFallback);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityValuation _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(valuationDates, _that.getValuationDates())) return false;
			if (!Objects.equals(valuationTimeType, _that.getValuationTimeType())) return false;
			if (!Objects.equals(valuationTime, _that.getValuationTime())) return false;
			if (!Objects.equals(futuresPriceValuation, _that.getFuturesPriceValuation())) return false;
			if (!Objects.equals(optionsPriceValuation, _that.getOptionsPriceValuation())) return false;
			if (!Objects.equals(numberOfValuationDates, _that.getNumberOfValuationDates())) return false;
			if (!Objects.equals(dividendValuationDates, _that.getDividendValuationDates())) return false;
			if (!Objects.equals(fPVFinalPriceElectionFallback, _that.getFPVFinalPriceElectionFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDates != null ? valuationDates.hashCode() : 0);
			_result = 31 * _result + (valuationTimeType != null ? valuationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTime != null ? valuationTime.hashCode() : 0);
			_result = 31 * _result + (futuresPriceValuation != null ? futuresPriceValuation.hashCode() : 0);
			_result = 31 * _result + (optionsPriceValuation != null ? optionsPriceValuation.hashCode() : 0);
			_result = 31 * _result + (numberOfValuationDates != null ? numberOfValuationDates.hashCode() : 0);
			_result = 31 * _result + (dividendValuationDates != null ? dividendValuationDates.hashCode() : 0);
			_result = 31 * _result + (fPVFinalPriceElectionFallback != null ? fPVFinalPriceElectionFallback.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityValuationBuilder {" +
				"id=" + this.id + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"valuationDates=" + this.valuationDates + ", " +
				"valuationTimeType=" + this.valuationTimeType + ", " +
				"valuationTime=" + this.valuationTime + ", " +
				"futuresPriceValuation=" + this.futuresPriceValuation + ", " +
				"optionsPriceValuation=" + this.optionsPriceValuation + ", " +
				"numberOfValuationDates=" + this.numberOfValuationDates + ", " +
				"dividendValuationDates=" + this.dividendValuationDates + ", " +
				"fPVFinalPriceElectionFallback=" + this.fPVFinalPriceElectionFallback +
			'}';
		}
	}
}
