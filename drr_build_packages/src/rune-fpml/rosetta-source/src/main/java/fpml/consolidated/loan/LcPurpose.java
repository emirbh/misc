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
import fpml.consolidated.loan.meta.LcPurposeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of L/C purposes.
 *
 */
@RosettaDataType(value="LcPurpose", builder=LcPurpose.LcPurposeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcPurpose", model="fpml", builder=LcPurpose.LcPurposeBuilderImpl.class, version="2.1.1")
public interface LcPurpose extends RosettaModelObject {

	LcPurposeMeta metaData = new LcPurposeMeta();

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
	String getLcPurposeScheme();

	/*********************** Build Methods  ***********************/
	LcPurpose build();
	
	LcPurpose.LcPurposeBuilder toBuilder();
	
	static LcPurpose.LcPurposeBuilder builder() {
		return new LcPurpose.LcPurposeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcPurpose> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcPurpose> getType() {
		return LcPurpose.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lcPurposeScheme"), String.class, getLcPurposeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcPurposeBuilder extends LcPurpose, RosettaModelObjectBuilder {
		LcPurpose.LcPurposeBuilder setValue(String value);
		LcPurpose.LcPurposeBuilder setLcPurposeScheme(String lcPurposeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lcPurposeScheme"), String.class, getLcPurposeScheme(), this);
		}
		

		LcPurpose.LcPurposeBuilder prune();
	}

	/*********************** Immutable Implementation of LcPurpose  ***********************/
	class LcPurposeImpl implements LcPurpose {
		private final String value;
		private final String lcPurposeScheme;
		
		protected LcPurposeImpl(LcPurpose.LcPurposeBuilder builder) {
			this.value = builder.getValue();
			this.lcPurposeScheme = builder.getLcPurposeScheme();
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
		@RosettaAttribute("lcPurposeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcPurposeScheme")
		public String getLcPurposeScheme() {
			return lcPurposeScheme;
		}
		
		@Override
		public LcPurpose build() {
			return this;
		}
		
		@Override
		public LcPurpose.LcPurposeBuilder toBuilder() {
			LcPurpose.LcPurposeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcPurpose.LcPurposeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLcPurposeScheme()).ifPresent(builder::setLcPurposeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcPurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcPurposeScheme, _that.getLcPurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcPurposeScheme != null ? lcPurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcPurpose {" +
				"value=" + this.value + ", " +
				"lcPurposeScheme=" + this.lcPurposeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LcPurpose  ***********************/
	class LcPurposeBuilderImpl implements LcPurpose.LcPurposeBuilder {
	
		protected String value;
		protected String lcPurposeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lcPurposeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcPurposeScheme")
		public String getLcPurposeScheme() {
			return lcPurposeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LcPurpose.LcPurposeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("lcPurposeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcPurposeScheme")
		@Override
		public LcPurpose.LcPurposeBuilder setLcPurposeScheme(String _lcPurposeScheme) {
			this.lcPurposeScheme = _lcPurposeScheme == null ? null : _lcPurposeScheme;
			return this;
		}
		
		@Override
		public LcPurpose build() {
			return new LcPurpose.LcPurposeImpl(this);
		}
		
		@Override
		public LcPurpose.LcPurposeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcPurpose.LcPurposeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLcPurposeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcPurpose.LcPurposeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LcPurpose.LcPurposeBuilder o = (LcPurpose.LcPurposeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLcPurposeScheme(), o.getLcPurposeScheme(), this::setLcPurposeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LcPurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lcPurposeScheme, _that.getLcPurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lcPurposeScheme != null ? lcPurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcPurposeBuilder {" +
				"value=" + this.value + ", " +
				"lcPurposeScheme=" + this.lcPurposeScheme +
			'}';
		}
	}
}
