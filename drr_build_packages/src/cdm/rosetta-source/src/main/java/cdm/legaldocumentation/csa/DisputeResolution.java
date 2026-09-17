package cdm.legaldocumentation.csa;

import cdm.base.datetime.BusinessCenterTime;
import cdm.legaldocumentation.csa.meta.DisputeResolutionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the election terms under which a party disputes the Value of any Transfer of Eligible Credit Support or Posted Credit Support.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(g)" * name "Dispute Resolution"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(h)" * name "Dispute Resolution"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(g)" * name "Dispute Resolution"
 *
 * Provision 
 *
 */
@RosettaDataType(value="DisputeResolution", builder=DisputeResolution.DisputeResolutionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="DisputeResolution", model="cdm", builder=DisputeResolution.DisputeResolutionBuilderImpl.class, version="6.23.0")
public interface DisputeResolution extends RosettaModelObject {

	DisputeResolutionMeta metaData = new DisputeResolutionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time by which the dispute needs to be resolved, failure of which would trigger a recalculation alongside a process that is specified as part of the agreement.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
	 * paragraph "3 General Principles" * clause "(g)(i)" * name "Resolution Time"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(g)(i)" * name "Resolution Time"
	 *
	 * Provision 
	 *
	 */
	BusinessCenterTime getResolutionTime();
	/**
	 * The custom Resolution Time election that might be specified by the parties.
	 */
	String getOtherTerms();
	/**
	 * The method of calculation for determining value for the purposes of a Variation Margin agreement.
	 */
	String getValueTerms();
	/**
	 * The alternative dispute resolution procedure if specified.
	 */
	String getAlternativeTerms();
	/**
	 * The elections to specify terms for recalculation of the market value of posted collateral.
	 */
	RecalculationOfValue getRecalculationOfValue();
	/**
	 * Definition of a point of time un the following LBD to the date of notice in the resolution process at which the recalculation of the disputed amount(s) begins if the consultation process has not resolved the dispute.
	 */
	BusinessCenterTime getLegacyResolutionTime();
	/**
	 * Alternative procedures to those in the pre-print for resolving collateral related disputes.
	 */
	LegacyResolutionAlternative getLegacyAlternative();
	/**
	 * Methodology for resolving disputes in respect of the determination of the value of collateral.
	 */
	LegacyResolutionValue getLegacyValue();

	/*********************** Build Methods  ***********************/
	DisputeResolution build();
	
	DisputeResolution.DisputeResolutionBuilder toBuilder();
	
	static DisputeResolution.DisputeResolutionBuilder builder() {
		return new DisputeResolution.DisputeResolutionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DisputeResolution> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DisputeResolution> getType() {
		return DisputeResolution.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("resolutionTime"), processor, BusinessCenterTime.class, getResolutionTime());
		processor.processBasic(path.newSubPath("otherTerms"), String.class, getOtherTerms(), this);
		processor.processBasic(path.newSubPath("valueTerms"), String.class, getValueTerms(), this);
		processor.processBasic(path.newSubPath("alternativeTerms"), String.class, getAlternativeTerms(), this);
		processRosetta(path.newSubPath("recalculationOfValue"), processor, RecalculationOfValue.class, getRecalculationOfValue());
		processRosetta(path.newSubPath("legacyResolutionTime"), processor, BusinessCenterTime.class, getLegacyResolutionTime());
		processRosetta(path.newSubPath("legacyAlternative"), processor, LegacyResolutionAlternative.class, getLegacyAlternative());
		processRosetta(path.newSubPath("legacyValue"), processor, LegacyResolutionValue.class, getLegacyValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DisputeResolutionBuilder extends DisputeResolution, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateResolutionTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getResolutionTime();
		RecalculationOfValue.RecalculationOfValueBuilder getOrCreateRecalculationOfValue();
		@Override
		RecalculationOfValue.RecalculationOfValueBuilder getRecalculationOfValue();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLegacyResolutionTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLegacyResolutionTime();
		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder getOrCreateLegacyAlternative();
		@Override
		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder getLegacyAlternative();
		LegacyResolutionValue.LegacyResolutionValueBuilder getOrCreateLegacyValue();
		@Override
		LegacyResolutionValue.LegacyResolutionValueBuilder getLegacyValue();
		DisputeResolution.DisputeResolutionBuilder setResolutionTime(BusinessCenterTime resolutionTime);
		DisputeResolution.DisputeResolutionBuilder setOtherTerms(String otherTerms);
		DisputeResolution.DisputeResolutionBuilder setValueTerms(String valueTerms);
		DisputeResolution.DisputeResolutionBuilder setAlternativeTerms(String alternativeTerms);
		DisputeResolution.DisputeResolutionBuilder setRecalculationOfValue(RecalculationOfValue recalculationOfValue);
		DisputeResolution.DisputeResolutionBuilder setLegacyResolutionTime(BusinessCenterTime legacyResolutionTime);
		DisputeResolution.DisputeResolutionBuilder setLegacyAlternative(LegacyResolutionAlternative legacyAlternative);
		DisputeResolution.DisputeResolutionBuilder setLegacyValue(LegacyResolutionValue legacyValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("resolutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getResolutionTime());
			processor.processBasic(path.newSubPath("otherTerms"), String.class, getOtherTerms(), this);
			processor.processBasic(path.newSubPath("valueTerms"), String.class, getValueTerms(), this);
			processor.processBasic(path.newSubPath("alternativeTerms"), String.class, getAlternativeTerms(), this);
			processRosetta(path.newSubPath("recalculationOfValue"), processor, RecalculationOfValue.RecalculationOfValueBuilder.class, getRecalculationOfValue());
			processRosetta(path.newSubPath("legacyResolutionTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLegacyResolutionTime());
			processRosetta(path.newSubPath("legacyAlternative"), processor, LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder.class, getLegacyAlternative());
			processRosetta(path.newSubPath("legacyValue"), processor, LegacyResolutionValue.LegacyResolutionValueBuilder.class, getLegacyValue());
		}
		

		DisputeResolution.DisputeResolutionBuilder prune();
	}

	/*********************** Immutable Implementation of DisputeResolution  ***********************/
	class DisputeResolutionImpl implements DisputeResolution {
		private final BusinessCenterTime resolutionTime;
		private final String otherTerms;
		private final String valueTerms;
		private final String alternativeTerms;
		private final RecalculationOfValue recalculationOfValue;
		private final BusinessCenterTime legacyResolutionTime;
		private final LegacyResolutionAlternative legacyAlternative;
		private final LegacyResolutionValue legacyValue;
		
		protected DisputeResolutionImpl(DisputeResolution.DisputeResolutionBuilder builder) {
			this.resolutionTime = ofNullable(builder.getResolutionTime()).map(f->f.build()).orElse(null);
			this.otherTerms = builder.getOtherTerms();
			this.valueTerms = builder.getValueTerms();
			this.alternativeTerms = builder.getAlternativeTerms();
			this.recalculationOfValue = ofNullable(builder.getRecalculationOfValue()).map(f->f.build()).orElse(null);
			this.legacyResolutionTime = ofNullable(builder.getLegacyResolutionTime()).map(f->f.build()).orElse(null);
			this.legacyAlternative = ofNullable(builder.getLegacyAlternative()).map(f->f.build()).orElse(null);
			this.legacyValue = ofNullable(builder.getLegacyValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("resolutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resolutionTime")
		public BusinessCenterTime getResolutionTime() {
			return resolutionTime;
		}
		
		@Override
		@RosettaAttribute("otherTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTerms")
		public String getOtherTerms() {
			return otherTerms;
		}
		
		@Override
		@RosettaAttribute("valueTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueTerms")
		public String getValueTerms() {
			return valueTerms;
		}
		
		@Override
		@RosettaAttribute("alternativeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("alternativeTerms")
		public String getAlternativeTerms() {
			return alternativeTerms;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recalculationOfValue")
		public RecalculationOfValue getRecalculationOfValue() {
			return recalculationOfValue;
		}
		
		@Override
		@RosettaAttribute("legacyResolutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyResolutionTime")
		public BusinessCenterTime getLegacyResolutionTime() {
			return legacyResolutionTime;
		}
		
		@Override
		@RosettaAttribute("legacyAlternative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyAlternative")
		public LegacyResolutionAlternative getLegacyAlternative() {
			return legacyAlternative;
		}
		
		@Override
		@RosettaAttribute("legacyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValue")
		public LegacyResolutionValue getLegacyValue() {
			return legacyValue;
		}
		
		@Override
		public DisputeResolution build() {
			return this;
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder toBuilder() {
			DisputeResolution.DisputeResolutionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DisputeResolution.DisputeResolutionBuilder builder) {
			ofNullable(getResolutionTime()).ifPresent(builder::setResolutionTime);
			ofNullable(getOtherTerms()).ifPresent(builder::setOtherTerms);
			ofNullable(getValueTerms()).ifPresent(builder::setValueTerms);
			ofNullable(getAlternativeTerms()).ifPresent(builder::setAlternativeTerms);
			ofNullable(getRecalculationOfValue()).ifPresent(builder::setRecalculationOfValue);
			ofNullable(getLegacyResolutionTime()).ifPresent(builder::setLegacyResolutionTime);
			ofNullable(getLegacyAlternative()).ifPresent(builder::setLegacyAlternative);
			ofNullable(getLegacyValue()).ifPresent(builder::setLegacyValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisputeResolution _that = getType().cast(o);
		
			if (!Objects.equals(resolutionTime, _that.getResolutionTime())) return false;
			if (!Objects.equals(otherTerms, _that.getOtherTerms())) return false;
			if (!Objects.equals(valueTerms, _that.getValueTerms())) return false;
			if (!Objects.equals(alternativeTerms, _that.getAlternativeTerms())) return false;
			if (!Objects.equals(recalculationOfValue, _that.getRecalculationOfValue())) return false;
			if (!Objects.equals(legacyResolutionTime, _that.getLegacyResolutionTime())) return false;
			if (!Objects.equals(legacyAlternative, _that.getLegacyAlternative())) return false;
			if (!Objects.equals(legacyValue, _that.getLegacyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resolutionTime != null ? resolutionTime.hashCode() : 0);
			_result = 31 * _result + (otherTerms != null ? otherTerms.hashCode() : 0);
			_result = 31 * _result + (valueTerms != null ? valueTerms.hashCode() : 0);
			_result = 31 * _result + (alternativeTerms != null ? alternativeTerms.hashCode() : 0);
			_result = 31 * _result + (recalculationOfValue != null ? recalculationOfValue.hashCode() : 0);
			_result = 31 * _result + (legacyResolutionTime != null ? legacyResolutionTime.hashCode() : 0);
			_result = 31 * _result + (legacyAlternative != null ? legacyAlternative.hashCode() : 0);
			_result = 31 * _result + (legacyValue != null ? legacyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisputeResolution {" +
				"resolutionTime=" + this.resolutionTime + ", " +
				"otherTerms=" + this.otherTerms + ", " +
				"valueTerms=" + this.valueTerms + ", " +
				"alternativeTerms=" + this.alternativeTerms + ", " +
				"recalculationOfValue=" + this.recalculationOfValue + ", " +
				"legacyResolutionTime=" + this.legacyResolutionTime + ", " +
				"legacyAlternative=" + this.legacyAlternative + ", " +
				"legacyValue=" + this.legacyValue +
			'}';
		}
	}

	/*********************** Builder Implementation of DisputeResolution  ***********************/
	class DisputeResolutionBuilderImpl implements DisputeResolution.DisputeResolutionBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder resolutionTime;
		protected String otherTerms;
		protected String valueTerms;
		protected String alternativeTerms;
		protected RecalculationOfValue.RecalculationOfValueBuilder recalculationOfValue;
		protected BusinessCenterTime.BusinessCenterTimeBuilder legacyResolutionTime;
		protected LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder legacyAlternative;
		protected LegacyResolutionValue.LegacyResolutionValueBuilder legacyValue;
		
		@Override
		@RosettaAttribute("resolutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resolutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getResolutionTime() {
			return resolutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateResolutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (resolutionTime!=null) {
				result = resolutionTime;
			}
			else {
				result = resolutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherTerms")
		public String getOtherTerms() {
			return otherTerms;
		}
		
		@Override
		@RosettaAttribute("valueTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueTerms")
		public String getValueTerms() {
			return valueTerms;
		}
		
		@Override
		@RosettaAttribute("alternativeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("alternativeTerms")
		public String getAlternativeTerms() {
			return alternativeTerms;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recalculationOfValue")
		public RecalculationOfValue.RecalculationOfValueBuilder getRecalculationOfValue() {
			return recalculationOfValue;
		}
		
		@Override
		public RecalculationOfValue.RecalculationOfValueBuilder getOrCreateRecalculationOfValue() {
			RecalculationOfValue.RecalculationOfValueBuilder result;
			if (recalculationOfValue!=null) {
				result = recalculationOfValue;
			}
			else {
				result = recalculationOfValue = RecalculationOfValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyResolutionTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyResolutionTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLegacyResolutionTime() {
			return legacyResolutionTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLegacyResolutionTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (legacyResolutionTime!=null) {
				result = legacyResolutionTime;
			}
			else {
				result = legacyResolutionTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyAlternative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyAlternative")
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder getLegacyAlternative() {
			return legacyAlternative;
		}
		
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder getOrCreateLegacyAlternative() {
			LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder result;
			if (legacyAlternative!=null) {
				result = legacyAlternative;
			}
			else {
				result = legacyAlternative = LegacyResolutionAlternative.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValue")
		public LegacyResolutionValue.LegacyResolutionValueBuilder getLegacyValue() {
			return legacyValue;
		}
		
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder getOrCreateLegacyValue() {
			LegacyResolutionValue.LegacyResolutionValueBuilder result;
			if (legacyValue!=null) {
				result = legacyValue;
			}
			else {
				result = legacyValue = LegacyResolutionValue.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("resolutionTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resolutionTime")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setResolutionTime(BusinessCenterTime _resolutionTime) {
			this.resolutionTime = _resolutionTime == null ? null : _resolutionTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherTerms")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setOtherTerms(String _otherTerms) {
			this.otherTerms = _otherTerms == null ? null : _otherTerms;
			return this;
		}
		
		@RosettaAttribute("valueTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valueTerms")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setValueTerms(String _valueTerms) {
			this.valueTerms = _valueTerms == null ? null : _valueTerms;
			return this;
		}
		
		@RosettaAttribute("alternativeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("alternativeTerms")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setAlternativeTerms(String _alternativeTerms) {
			this.alternativeTerms = _alternativeTerms == null ? null : _alternativeTerms;
			return this;
		}
		
		@RosettaAttribute("recalculationOfValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recalculationOfValue")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setRecalculationOfValue(RecalculationOfValue _recalculationOfValue) {
			this.recalculationOfValue = _recalculationOfValue == null ? null : _recalculationOfValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyResolutionTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyResolutionTime")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setLegacyResolutionTime(BusinessCenterTime _legacyResolutionTime) {
			this.legacyResolutionTime = _legacyResolutionTime == null ? null : _legacyResolutionTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyAlternative")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyAlternative")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setLegacyAlternative(LegacyResolutionAlternative _legacyAlternative) {
			this.legacyAlternative = _legacyAlternative == null ? null : _legacyAlternative.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyValue")
		@Override
		public DisputeResolution.DisputeResolutionBuilder setLegacyValue(LegacyResolutionValue _legacyValue) {
			this.legacyValue = _legacyValue == null ? null : _legacyValue.toBuilder();
			return this;
		}
		
		@Override
		public DisputeResolution build() {
			return new DisputeResolution.DisputeResolutionImpl(this);
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisputeResolution.DisputeResolutionBuilder prune() {
			if (resolutionTime!=null && !resolutionTime.prune().hasData()) resolutionTime = null;
			if (recalculationOfValue!=null && !recalculationOfValue.prune().hasData()) recalculationOfValue = null;
			if (legacyResolutionTime!=null && !legacyResolutionTime.prune().hasData()) legacyResolutionTime = null;
			if (legacyAlternative!=null && !legacyAlternative.prune().hasData()) legacyAlternative = null;
			if (legacyValue!=null && !legacyValue.prune().hasData()) legacyValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResolutionTime()!=null && getResolutionTime().hasData()) return true;
			if (getOtherTerms()!=null) return true;
			if (getValueTerms()!=null) return true;
			if (getAlternativeTerms()!=null) return true;
			if (getRecalculationOfValue()!=null && getRecalculationOfValue().hasData()) return true;
			if (getLegacyResolutionTime()!=null && getLegacyResolutionTime().hasData()) return true;
			if (getLegacyAlternative()!=null && getLegacyAlternative().hasData()) return true;
			if (getLegacyValue()!=null && getLegacyValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DisputeResolution.DisputeResolutionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DisputeResolution.DisputeResolutionBuilder o = (DisputeResolution.DisputeResolutionBuilder) other;
			
			merger.mergeRosetta(getResolutionTime(), o.getResolutionTime(), this::setResolutionTime);
			merger.mergeRosetta(getRecalculationOfValue(), o.getRecalculationOfValue(), this::setRecalculationOfValue);
			merger.mergeRosetta(getLegacyResolutionTime(), o.getLegacyResolutionTime(), this::setLegacyResolutionTime);
			merger.mergeRosetta(getLegacyAlternative(), o.getLegacyAlternative(), this::setLegacyAlternative);
			merger.mergeRosetta(getLegacyValue(), o.getLegacyValue(), this::setLegacyValue);
			
			merger.mergeBasic(getOtherTerms(), o.getOtherTerms(), this::setOtherTerms);
			merger.mergeBasic(getValueTerms(), o.getValueTerms(), this::setValueTerms);
			merger.mergeBasic(getAlternativeTerms(), o.getAlternativeTerms(), this::setAlternativeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DisputeResolution _that = getType().cast(o);
		
			if (!Objects.equals(resolutionTime, _that.getResolutionTime())) return false;
			if (!Objects.equals(otherTerms, _that.getOtherTerms())) return false;
			if (!Objects.equals(valueTerms, _that.getValueTerms())) return false;
			if (!Objects.equals(alternativeTerms, _that.getAlternativeTerms())) return false;
			if (!Objects.equals(recalculationOfValue, _that.getRecalculationOfValue())) return false;
			if (!Objects.equals(legacyResolutionTime, _that.getLegacyResolutionTime())) return false;
			if (!Objects.equals(legacyAlternative, _that.getLegacyAlternative())) return false;
			if (!Objects.equals(legacyValue, _that.getLegacyValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resolutionTime != null ? resolutionTime.hashCode() : 0);
			_result = 31 * _result + (otherTerms != null ? otherTerms.hashCode() : 0);
			_result = 31 * _result + (valueTerms != null ? valueTerms.hashCode() : 0);
			_result = 31 * _result + (alternativeTerms != null ? alternativeTerms.hashCode() : 0);
			_result = 31 * _result + (recalculationOfValue != null ? recalculationOfValue.hashCode() : 0);
			_result = 31 * _result + (legacyResolutionTime != null ? legacyResolutionTime.hashCode() : 0);
			_result = 31 * _result + (legacyAlternative != null ? legacyAlternative.hashCode() : 0);
			_result = 31 * _result + (legacyValue != null ? legacyValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DisputeResolutionBuilder {" +
				"resolutionTime=" + this.resolutionTime + ", " +
				"otherTerms=" + this.otherTerms + ", " +
				"valueTerms=" + this.valueTerms + ", " +
				"alternativeTerms=" + this.alternativeTerms + ", " +
				"recalculationOfValue=" + this.recalculationOfValue + ", " +
				"legacyResolutionTime=" + this.legacyResolutionTime + ", " +
				"legacyAlternative=" + this.legacyAlternative + ", " +
				"legacyValue=" + this.legacyValue +
			'}';
		}
	}
}
