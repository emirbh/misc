package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.NonAccruingFeeTypeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a single non-accruing facility fee type within a syndicated loan structure.
 *
 */
@RosettaDataType(value="NonAccruingFeeTypeId", builder=NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="NonAccruingFeeTypeId", model="fpml", builder=NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilderImpl.class, version="2.1.1")
public interface NonAccruingFeeTypeId extends RosettaModelObject {

	NonAccruingFeeTypeIdMeta metaData = new NonAccruingFeeTypeIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getNonAccruingFeeTypeIdScheme();

	/*********************** Build Methods  ***********************/
	NonAccruingFeeTypeId build();
	
	NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder toBuilder();
	
	static NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder builder() {
		return new NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonAccruingFeeTypeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonAccruingFeeTypeId> getType() {
		return NonAccruingFeeTypeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("nonAccruingFeeTypeIdScheme"), String.class, getNonAccruingFeeTypeIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonAccruingFeeTypeIdBuilder extends NonAccruingFeeTypeId, RosettaModelObjectBuilder {
		NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder setValue(String value);
		NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder setNonAccruingFeeTypeIdScheme(String nonAccruingFeeTypeIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("nonAccruingFeeTypeIdScheme"), String.class, getNonAccruingFeeTypeIdScheme(), this);
		}
		

		NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder prune();
	}

	/*********************** Immutable Implementation of NonAccruingFeeTypeId  ***********************/
	class NonAccruingFeeTypeIdImpl implements NonAccruingFeeTypeId {
		private final String value;
		private final String nonAccruingFeeTypeIdScheme;
		
		protected NonAccruingFeeTypeIdImpl(NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder builder) {
			this.value = builder.getValue();
			this.nonAccruingFeeTypeIdScheme = builder.getNonAccruingFeeTypeIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeeTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeIdScheme")
		public String getNonAccruingFeeTypeIdScheme() {
			return nonAccruingFeeTypeIdScheme;
		}
		
		@Override
		public NonAccruingFeeTypeId build() {
			return this;
		}
		
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder toBuilder() {
			NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getNonAccruingFeeTypeIdScheme()).ifPresent(builder::setNonAccruingFeeTypeIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonAccruingFeeTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(nonAccruingFeeTypeIdScheme, _that.getNonAccruingFeeTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeeTypeIdScheme != null ? nonAccruingFeeTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonAccruingFeeTypeId {" +
				"value=" + this.value + ", " +
				"nonAccruingFeeTypeIdScheme=" + this.nonAccruingFeeTypeIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of NonAccruingFeeTypeId  ***********************/
	class NonAccruingFeeTypeIdBuilderImpl implements NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder {
	
		protected String value;
		protected String nonAccruingFeeTypeIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("nonAccruingFeeTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeIdScheme")
		public String getNonAccruingFeeTypeIdScheme() {
			return nonAccruingFeeTypeIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("nonAccruingFeeTypeIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonAccruingFeeTypeIdScheme")
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder setNonAccruingFeeTypeIdScheme(String _nonAccruingFeeTypeIdScheme) {
			this.nonAccruingFeeTypeIdScheme = _nonAccruingFeeTypeIdScheme == null ? null : _nonAccruingFeeTypeIdScheme;
			return this;
		}
		
		@Override
		public NonAccruingFeeTypeId build() {
			return new NonAccruingFeeTypeId.NonAccruingFeeTypeIdImpl(this);
		}
		
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getNonAccruingFeeTypeIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder o = (NonAccruingFeeTypeId.NonAccruingFeeTypeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getNonAccruingFeeTypeIdScheme(), o.getNonAccruingFeeTypeIdScheme(), this::setNonAccruingFeeTypeIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonAccruingFeeTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(nonAccruingFeeTypeIdScheme, _that.getNonAccruingFeeTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (nonAccruingFeeTypeIdScheme != null ? nonAccruingFeeTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonAccruingFeeTypeIdBuilder {" +
				"value=" + this.value + ", " +
				"nonAccruingFeeTypeIdScheme=" + this.nonAccruingFeeTypeIdScheme +
			'}';
		}
	}
}
