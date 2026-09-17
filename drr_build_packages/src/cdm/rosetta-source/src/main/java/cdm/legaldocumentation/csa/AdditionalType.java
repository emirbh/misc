package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.AdditionalTypeMeta;
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
 * The specification of the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(b)(B)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="AdditionalType", builder=AdditionalType.AdditionalTypeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdditionalType", model="cdm", builder=AdditionalType.AdditionalTypeBuilderImpl.class, version="6.23.0")
public interface AdditionalType extends RosettaModelObject {

	AdditionalTypeMeta metaData = new AdditionalTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a standard value.
	 */
	AdditionalTypeEnum getStandardValue();
	/**
	 * The qualification of the Additional Type of transaction that can require the collection or delivery of initial margin when specified as a custom value by the parties to the legal agreement.
	 */
	String getCustomValue();

	/*********************** Build Methods  ***********************/
	AdditionalType build();
	
	AdditionalType.AdditionalTypeBuilder toBuilder();
	
	static AdditionalType.AdditionalTypeBuilder builder() {
		return new AdditionalType.AdditionalTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalType> getType() {
		return AdditionalType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardValue"), AdditionalTypeEnum.class, getStandardValue(), this);
		processor.processBasic(path.newSubPath("customValue"), String.class, getCustomValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalTypeBuilder extends AdditionalType, RosettaModelObjectBuilder {
		AdditionalType.AdditionalTypeBuilder setStandardValue(AdditionalTypeEnum standardValue);
		AdditionalType.AdditionalTypeBuilder setCustomValue(String customValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardValue"), AdditionalTypeEnum.class, getStandardValue(), this);
			processor.processBasic(path.newSubPath("customValue"), String.class, getCustomValue(), this);
		}
		

		AdditionalType.AdditionalTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalType  ***********************/
	class AdditionalTypeImpl implements AdditionalType {
		private final AdditionalTypeEnum standardValue;
		private final String customValue;
		
		protected AdditionalTypeImpl(AdditionalType.AdditionalTypeBuilder builder) {
			this.standardValue = builder.getStandardValue();
			this.customValue = builder.getCustomValue();
		}
		
		@Override
		@RosettaAttribute("standardValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("standardValue")
		public AdditionalTypeEnum getStandardValue() {
			return standardValue;
		}
		
		@Override
		@RosettaAttribute("customValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customValue")
		public String getCustomValue() {
			return customValue;
		}
		
		@Override
		public AdditionalType build() {
			return this;
		}
		
		@Override
		public AdditionalType.AdditionalTypeBuilder toBuilder() {
			AdditionalType.AdditionalTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalType.AdditionalTypeBuilder builder) {
			ofNullable(getStandardValue()).ifPresent(builder::setStandardValue);
			ofNullable(getCustomValue()).ifPresent(builder::setCustomValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalType _that = getType().cast(o);
		
			if (!Objects.equals(standardValue, _that.getStandardValue())) return false;
			if (!Objects.equals(customValue, _that.getCustomValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardValue != null ? standardValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customValue != null ? customValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalType {" +
				"standardValue=" + this.standardValue + ", " +
				"customValue=" + this.customValue +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalType  ***********************/
	class AdditionalTypeBuilderImpl implements AdditionalType.AdditionalTypeBuilder {
	
		protected AdditionalTypeEnum standardValue;
		protected String customValue;
		
		@Override
		@RosettaAttribute("standardValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("standardValue")
		public AdditionalTypeEnum getStandardValue() {
			return standardValue;
		}
		
		@Override
		@RosettaAttribute("customValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customValue")
		public String getCustomValue() {
			return customValue;
		}
		
		@RosettaAttribute("standardValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("standardValue")
		@Override
		public AdditionalType.AdditionalTypeBuilder setStandardValue(AdditionalTypeEnum _standardValue) {
			this.standardValue = _standardValue == null ? null : _standardValue;
			return this;
		}
		
		@RosettaAttribute("customValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customValue")
		@Override
		public AdditionalType.AdditionalTypeBuilder setCustomValue(String _customValue) {
			this.customValue = _customValue == null ? null : _customValue;
			return this;
		}
		
		@Override
		public AdditionalType build() {
			return new AdditionalType.AdditionalTypeImpl(this);
		}
		
		@Override
		public AdditionalType.AdditionalTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalType.AdditionalTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardValue()!=null) return true;
			if (getCustomValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalType.AdditionalTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalType.AdditionalTypeBuilder o = (AdditionalType.AdditionalTypeBuilder) other;
			
			
			merger.mergeBasic(getStandardValue(), o.getStandardValue(), this::setStandardValue);
			merger.mergeBasic(getCustomValue(), o.getCustomValue(), this::setCustomValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalType _that = getType().cast(o);
		
			if (!Objects.equals(standardValue, _that.getStandardValue())) return false;
			if (!Objects.equals(customValue, _that.getCustomValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardValue != null ? standardValue.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customValue != null ? customValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTypeBuilder {" +
				"standardValue=" + this.standardValue + ", " +
				"customValue=" + this.customValue +
			'}';
		}
	}
}
