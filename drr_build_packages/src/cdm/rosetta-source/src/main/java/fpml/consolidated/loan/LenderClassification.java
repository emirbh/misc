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
import fpml.consolidated.loan.meta.LenderClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of lender classifications. These are used to derive other rules associated with specific lender types.
 *
 */
@RosettaDataType(value="LenderClassification", builder=LenderClassification.LenderClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LenderClassification", model="fpml", builder=LenderClassification.LenderClassificationBuilderImpl.class, version="2.1.1")
public interface LenderClassification extends RosettaModelObject {

	LenderClassificationMeta metaData = new LenderClassificationMeta();

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
	String getLenderClassificationScheme();

	/*********************** Build Methods  ***********************/
	LenderClassification build();
	
	LenderClassification.LenderClassificationBuilder toBuilder();
	
	static LenderClassification.LenderClassificationBuilder builder() {
		return new LenderClassification.LenderClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LenderClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LenderClassification> getType() {
		return LenderClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lenderClassificationScheme"), String.class, getLenderClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LenderClassificationBuilder extends LenderClassification, RosettaModelObjectBuilder {
		LenderClassification.LenderClassificationBuilder setValue(String value);
		LenderClassification.LenderClassificationBuilder setLenderClassificationScheme(String lenderClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lenderClassificationScheme"), String.class, getLenderClassificationScheme(), this);
		}
		

		LenderClassification.LenderClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of LenderClassification  ***********************/
	class LenderClassificationImpl implements LenderClassification {
		private final String value;
		private final String lenderClassificationScheme;
		
		protected LenderClassificationImpl(LenderClassification.LenderClassificationBuilder builder) {
			this.value = builder.getValue();
			this.lenderClassificationScheme = builder.getLenderClassificationScheme();
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
		@RosettaAttribute("lenderClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderClassificationScheme")
		public String getLenderClassificationScheme() {
			return lenderClassificationScheme;
		}
		
		@Override
		public LenderClassification build() {
			return this;
		}
		
		@Override
		public LenderClassification.LenderClassificationBuilder toBuilder() {
			LenderClassification.LenderClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LenderClassification.LenderClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLenderClassificationScheme()).ifPresent(builder::setLenderClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lenderClassificationScheme, _that.getLenderClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lenderClassificationScheme != null ? lenderClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderClassification {" +
				"value=" + this.value + ", " +
				"lenderClassificationScheme=" + this.lenderClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LenderClassification  ***********************/
	class LenderClassificationBuilderImpl implements LenderClassification.LenderClassificationBuilder {
	
		protected String value;
		protected String lenderClassificationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lenderClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderClassificationScheme")
		public String getLenderClassificationScheme() {
			return lenderClassificationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LenderClassification.LenderClassificationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("lenderClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderClassificationScheme")
		@Override
		public LenderClassification.LenderClassificationBuilder setLenderClassificationScheme(String _lenderClassificationScheme) {
			this.lenderClassificationScheme = _lenderClassificationScheme == null ? null : _lenderClassificationScheme;
			return this;
		}
		
		@Override
		public LenderClassification build() {
			return new LenderClassification.LenderClassificationImpl(this);
		}
		
		@Override
		public LenderClassification.LenderClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderClassification.LenderClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLenderClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderClassification.LenderClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LenderClassification.LenderClassificationBuilder o = (LenderClassification.LenderClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLenderClassificationScheme(), o.getLenderClassificationScheme(), this::setLenderClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lenderClassificationScheme, _that.getLenderClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lenderClassificationScheme != null ? lenderClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderClassificationBuilder {" +
				"value=" + this.value + ", " +
				"lenderClassificationScheme=" + this.lenderClassificationScheme +
			'}';
		}
	}
}
