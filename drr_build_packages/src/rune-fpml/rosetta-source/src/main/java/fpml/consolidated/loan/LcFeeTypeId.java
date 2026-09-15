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
import fpml.consolidated.loan.meta.LcFeeTypeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a single letter of credit fee type within a syndicated loan structure.
 *
 */
@RosettaDataType(value="LcFeeTypeId", builder=LcFeeTypeId.LcFeeTypeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcFeeTypeId", model="fpml", builder=LcFeeTypeId.LcFeeTypeIdBuilderImpl.class, version="2.1.1")
public interface LcFeeTypeId extends RosettaModelObject {

	LcFeeTypeIdMeta metaData = new LcFeeTypeIdMeta();

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
	String getLcFeeTypeIdScheme();

	/*********************** Build Methods  ***********************/
	LcFeeTypeId build();
	
	LcFeeTypeId.LcFeeTypeIdBuilder toBuilder();
	
	static LcFeeTypeId.LcFeeTypeIdBuilder builder() {
		return new LcFeeTypeId.LcFeeTypeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcFeeTypeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcFeeTypeId> getType() {
		return LcFeeTypeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lcFeeTypeIdScheme"), String.class, getLcFeeTypeIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcFeeTypeIdBuilder extends LcFeeTypeId, RosettaModelObjectBuilder {
		LcFeeTypeId.LcFeeTypeIdBuilder setValue(String value);
		LcFeeTypeId.LcFeeTypeIdBuilder setLcFeeTypeIdScheme(String lcFeeTypeIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lcFeeTypeIdScheme"), String.class, getLcFeeTypeIdScheme(), this);
		}
		

		LcFeeTypeId.LcFeeTypeIdBuilder prune();
	}

	/*********************** Immutable Implementation of LcFeeTypeId  ***********************/
	class LcFeeTypeIdImpl implements LcFeeTypeId {
		private final String value;
		private final String lcFeeTypeIdScheme;
		
		protected LcFeeTypeIdImpl(LcFeeTypeId.LcFeeTypeIdBuilder builder) {
			this.value = builder.getValue();
			this.lcFeeTypeIdScheme = builder.getLcFeeTypeIdScheme();
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
		@RosettaAttribute("lcFeeTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcFeeTypeIdScheme")
		public String getLcFeeTypeIdScheme() {
			return lcFeeTypeIdScheme;
		}
		
		@Override
		public LcFeeTypeId build() {
			return this;
		}
		
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder toBuilder() {
			LcFeeTypeId.LcFeeTypeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcFeeTypeId.LcFeeTypeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLcFeeTypeIdScheme()).ifPresent(builder::setLcFeeTypeIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcFeeTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcFeeTypeIdScheme, _that.getLcFeeTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcFeeTypeIdScheme != null ? lcFeeTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFeeTypeId {" +
				"value=" + this.value + ", " +
				"lcFeeTypeIdScheme=" + this.lcFeeTypeIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LcFeeTypeId  ***********************/
	class LcFeeTypeIdBuilderImpl implements LcFeeTypeId.LcFeeTypeIdBuilder {
	
		protected String value;
		protected String lcFeeTypeIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lcFeeTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcFeeTypeIdScheme")
		public String getLcFeeTypeIdScheme() {
			return lcFeeTypeIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("lcFeeTypeIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lcFeeTypeIdScheme")
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder setLcFeeTypeIdScheme(String _lcFeeTypeIdScheme) {
			this.lcFeeTypeIdScheme = _lcFeeTypeIdScheme == null ? null : _lcFeeTypeIdScheme;
			return this;
		}
		
		@Override
		public LcFeeTypeId build() {
			return new LcFeeTypeId.LcFeeTypeIdImpl(this);
		}
		
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLcFeeTypeIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LcFeeTypeId.LcFeeTypeIdBuilder o = (LcFeeTypeId.LcFeeTypeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLcFeeTypeIdScheme(), o.getLcFeeTypeIdScheme(), this::setLcFeeTypeIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcFeeTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcFeeTypeIdScheme, _that.getLcFeeTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcFeeTypeIdScheme != null ? lcFeeTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFeeTypeIdBuilder {" +
				"value=" + this.value + ", " +
				"lcFeeTypeIdScheme=" + this.lcFeeTypeIdScheme +
			'}';
		}
	}
}
