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
import fpml.consolidated.com.meta.CommodityFixedInterestCalculationMeta;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.IdentifiedRate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="CommodityFixedInterestCalculation", builder=CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityFixedInterestCalculation", model="fpml", builder=CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilderImpl.class, version="2.1.1")
public interface CommodityFixedInterestCalculation extends RosettaModelObject {

	CommodityFixedInterestCalculationMeta metaData = new CommodityFixedInterestCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calculation period fixed rate or "fee" rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05. When multiplied by the Notional Amount and the number of calendar days in the Calculation Period divided by the calendar days basis, is the fixed amount payed per Calculation Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calculation period fixed rate or "fee" rate. A per annum rate, expressed as a decimal. A fixed rate of 5% would be represented as 0.05. When multiplied by the Notional Amount and the number of calendar days in the Calculation Period divided by the calendar days basis, is the fixed amount payed per Calculation Period.
	 *
	 */
	IdentifiedRate getFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the basis for the adjustment of a rate from an annual rate to a rate appropriate for the Calculation Period: e.g. the number of calendar days in the Calculation Period divided by the calendar days basis e.g. actual number of days in the Calculation Period divided by 365.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the basis for the adjustment of a rate from an annual rate to a rate appropriate for the Calculation Period: e.g. the number of calendar days in the Calculation Period divided by the calendar days basis e.g. actual number of days in the Calculation Period divided by 365.
	 *
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	CommodityFixedInterestCalculation build();
	
	CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder toBuilder();
	
	static CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder builder() {
		return new CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedInterestCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityFixedInterestCalculation> getType() {
		return CommodityFixedInterestCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.class, getFixedRate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedInterestCalculationBuilder extends CommodityFixedInterestCalculation, RosettaModelObjectBuilder {
		IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate();
		@Override
		IdentifiedRate.IdentifiedRateBuilder getFixedRate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder setFixedRate(IdentifiedRate fixedRate);
		CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRate"), processor, IdentifiedRate.IdentifiedRateBuilder.class, getFixedRate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedInterestCalculation  ***********************/
	class CommodityFixedInterestCalculationImpl implements CommodityFixedInterestCalculation {
		private final IdentifiedRate fixedRate;
		private final DayCountFraction dayCountFraction;
		
		protected CommodityFixedInterestCalculationImpl(CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder builder) {
			this.fixedRate = ofNullable(builder.getFixedRate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public IdentifiedRate getFixedRate() {
			return fixedRate;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public CommodityFixedInterestCalculation build() {
			return this;
		}
		
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder toBuilder() {
			CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder builder) {
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedInterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedInterestCalculation {" +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedInterestCalculation  ***********************/
	class CommodityFixedInterestCalculationBuilderImpl implements CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder {
	
		protected IdentifiedRate.IdentifiedRateBuilder fixedRate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRate")
		public IdentifiedRate.IdentifiedRateBuilder getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public IdentifiedRate.IdentifiedRateBuilder getOrCreateFixedRate() {
			IdentifiedRate.IdentifiedRateBuilder result;
			if (fixedRate!=null) {
				result = fixedRate;
			}
			else {
				result = fixedRate = IdentifiedRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRate")
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder setFixedRate(IdentifiedRate _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedInterestCalculation build() {
			return new CommodityFixedInterestCalculation.CommodityFixedInterestCalculationImpl(this);
		}
		
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder prune() {
			if (fixedRate!=null && !fixedRate.prune().hasData()) fixedRate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRate()!=null && getFixedRate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder o = (CommodityFixedInterestCalculation.CommodityFixedInterestCalculationBuilder) other;
			
			merger.mergeRosetta(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedInterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedInterestCalculationBuilder {" +
				"fixedRate=" + this.fixedRate + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}';
		}
	}
}
