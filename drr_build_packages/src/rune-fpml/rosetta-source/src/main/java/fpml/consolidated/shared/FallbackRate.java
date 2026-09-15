package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FallbackRateMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines a fallback rate, which is a rate to be used in place of a publish term rate (such as an ibor rate) when that term rate ceases to be usable, whether because it ceases to be published or is deemed non-representative by regulator.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a fallback rate, which is a rate to be used in place of a publish term rate (such as an ibor rate) when that term rate ceases to be usable, whether because it ceases to be published or is deemed non-representative by regulator.
 *
 */
@RosettaDataType(value="FallbackRate", builder=FallbackRate.FallbackRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FallbackRate", model="fpml", builder=FallbackRate.FallbackRateBuilderImpl.class, version="2.1.1")
public interface FallbackRate extends RosettaModelObject {

	FallbackRateMeta metaData = new FallbackRateMeta();

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
	 * Provision The Applicable Fallback Effective Date, as defined in the 2021 ISDA Interest Rate Derivatives Definitions, Section 8.5.4. The date upon which the fallback rate becomes effective. This means that any rate observation for that date or for any subsequent date would use the fallback rate rather than the originally defined rate. This date will typically immediately follow the cessation of publication of the original term rate but could occur before that (e.g. if the original rate is deemed non-representative prior to cessation of publication). If the effective date occurs within a calculation period with multiple rate observations (because of averaging), observations prior to the effective date will use the original floating rate index, and observations on or after the effective date will use the fallback rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Applicable Fallback Effective Date, as defined in the 2021 ISDA Interest Rate Derivatives Definitions, Section 8.5.4. The date upon which the fallback rate becomes effective. This means that any rate observation for that date or for any subsequent date would use the fallback rate rather than the originally defined rate. This date will typically immediately follow the cessation of publication of the original term rate but could occur before that (e.g. if the original rate is deemed non-representative prior to cessation of publication). If the effective date occurs within a calculation period with multiple rate observations (because of averaging), observations prior to the effective date will use the original floating rate index, and observations on or after the effective date will use the fallback rate.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The benchmark rate used for computing the fallback rate. Typically this will be a risk-free overnight rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The benchmark rate used for computing the fallback rate. Typically this will be a risk-free overnight rate.
	 *
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This provides a representation of the approximate value of the fallback rate, i.e. a calculated rate that quite closely mimics the value anticipated to be published by the fallback rate administrator (once the spread adjustment is added).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This provides a representation of the approximate value of the fallback rate, i.e. a calculated rate that quite closely mimics the value anticipated to be published by the fallback rate administrator (once the spread adjustment is added).
	 *
	 */
	CalculationParameters getCalculationParameters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An amount to be added to the calculated value before subsequent use, in order to more closely replicate the original term rate, by adjusting for the economic or credit spread between risk-free rates and risky term rates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An amount to be added to the calculated value before subsequent use, in order to more closely replicate the original term rate, by adjusting for the economic or credit spread between risk-free rates and risky term rates.
	 *
	 */
	BigDecimal getSpreadAdjustment();

	/*********************** Build Methods  ***********************/
	FallbackRate build();
	
	FallbackRate.FallbackRateBuilder toBuilder();
	
	static FallbackRate.FallbackRateBuilder builder() {
		return new FallbackRate.FallbackRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FallbackRate> getType() {
		return FallbackRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.class, getCalculationParameters());
		processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackRateBuilder extends FallbackRate, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		@Override
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		CalculationParameters.CalculationParametersBuilder getOrCreateCalculationParameters();
		@Override
		CalculationParameters.CalculationParametersBuilder getCalculationParameters();
		FallbackRate.FallbackRateBuilder setId(String id);
		FallbackRate.FallbackRateBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		FallbackRate.FallbackRateBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		FallbackRate.FallbackRateBuilder setCalculationParameters(CalculationParameters calculationParameters);
		FallbackRate.FallbackRateBuilder setSpreadAdjustment(BigDecimal spreadAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("calculationParameters"), processor, CalculationParameters.CalculationParametersBuilder.class, getCalculationParameters());
			processor.processBasic(path.newSubPath("spreadAdjustment"), BigDecimal.class, getSpreadAdjustment(), this);
		}
		

		FallbackRate.FallbackRateBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackRate  ***********************/
	class FallbackRateImpl implements FallbackRate {
		private final String id;
		private final ZonedDateTime effectiveDate;
		private final FloatingRateIndex floatingRateIndex;
		private final CalculationParameters calculationParameters;
		private final BigDecimal spreadAdjustment;
		
		protected FallbackRateImpl(FallbackRate.FallbackRateBuilder builder) {
			this.id = builder.getId();
			this.effectiveDate = builder.getEffectiveDate();
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.calculationParameters = ofNullable(builder.getCalculationParameters()).map(f->f.build()).orElse(null);
			this.spreadAdjustment = builder.getSpreadAdjustment();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationParameters")
		public CalculationParameters getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@Override
		public FallbackRate build() {
			return this;
		}
		
		@Override
		public FallbackRate.FallbackRateBuilder toBuilder() {
			FallbackRate.FallbackRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackRate.FallbackRateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getCalculationParameters()).ifPresent(builder::setCalculationParameters);
			ofNullable(getSpreadAdjustment()).ifPresent(builder::setSpreadAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRate {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"calculationParameters=" + this.calculationParameters + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of FallbackRate  ***********************/
	class FallbackRateBuilderImpl implements FallbackRate.FallbackRateBuilder {
	
		protected String id;
		protected ZonedDateTime effectiveDate;
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected CalculationParameters.CalculationParametersBuilder calculationParameters;
		protected BigDecimal spreadAdjustment;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationParameters")
		public CalculationParameters.CalculationParametersBuilder getCalculationParameters() {
			return calculationParameters;
		}
		
		@Override
		public CalculationParameters.CalculationParametersBuilder getOrCreateCalculationParameters() {
			CalculationParameters.CalculationParametersBuilder result;
			if (calculationParameters!=null) {
				result = calculationParameters;
			}
			else {
				result = calculationParameters = CalculationParameters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadAdjustment")
		public BigDecimal getSpreadAdjustment() {
			return spreadAdjustment;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FallbackRate.FallbackRateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public FallbackRate.FallbackRateBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("floatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateIndex")
		@Override
		public FallbackRate.FallbackRateBuilder setFloatingRateIndex(FloatingRateIndex _floatingRateIndex) {
			this.floatingRateIndex = _floatingRateIndex == null ? null : _floatingRateIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationParameters")
		@Override
		public FallbackRate.FallbackRateBuilder setCalculationParameters(CalculationParameters _calculationParameters) {
			this.calculationParameters = _calculationParameters == null ? null : _calculationParameters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadAdjustment")
		@Override
		public FallbackRate.FallbackRateBuilder setSpreadAdjustment(BigDecimal _spreadAdjustment) {
			this.spreadAdjustment = _spreadAdjustment == null ? null : _spreadAdjustment;
			return this;
		}
		
		@Override
		public FallbackRate build() {
			return new FallbackRate.FallbackRateImpl(this);
		}
		
		@Override
		public FallbackRate.FallbackRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRate.FallbackRateBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (calculationParameters!=null && !calculationParameters.prune().hasData()) calculationParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEffectiveDate()!=null) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getCalculationParameters()!=null && getCalculationParameters().hasData()) return true;
			if (getSpreadAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRate.FallbackRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackRate.FallbackRateBuilder o = (FallbackRate.FallbackRateBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getCalculationParameters(), o.getCalculationParameters(), this::setCalculationParameters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getSpreadAdjustment(), o.getSpreadAdjustment(), this::setSpreadAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(calculationParameters, _that.getCalculationParameters())) return false;
			if (!Objects.equals(spreadAdjustment, _that.getSpreadAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (calculationParameters != null ? calculationParameters.hashCode() : 0);
			_result = 31 * _result + (spreadAdjustment != null ? spreadAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRateBuilder {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"calculationParameters=" + this.calculationParameters + ", " +
				"spreadAdjustment=" + this.spreadAdjustment +
			'}';
		}
	}
}
