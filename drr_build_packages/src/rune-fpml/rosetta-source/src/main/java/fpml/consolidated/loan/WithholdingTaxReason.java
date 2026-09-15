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
import fpml.consolidated.loan.meta.WithholdingTaxReasonMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of reasons for withholding tax being applied to a cash flow.
 *
 */
@RosettaDataType(value="WithholdingTaxReason", builder=WithholdingTaxReason.WithholdingTaxReasonBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WithholdingTaxReason", model="fpml", builder=WithholdingTaxReason.WithholdingTaxReasonBuilderImpl.class, version="2.1.1")
public interface WithholdingTaxReason extends RosettaModelObject {

	WithholdingTaxReasonMeta metaData = new WithholdingTaxReasonMeta();

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
	String getWithholdingTaxReasonScheme();

	/*********************** Build Methods  ***********************/
	WithholdingTaxReason build();
	
	WithholdingTaxReason.WithholdingTaxReasonBuilder toBuilder();
	
	static WithholdingTaxReason.WithholdingTaxReasonBuilder builder() {
		return new WithholdingTaxReason.WithholdingTaxReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WithholdingTaxReason> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WithholdingTaxReason> getType() {
		return WithholdingTaxReason.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("withholdingTaxReasonScheme"), String.class, getWithholdingTaxReasonScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithholdingTaxReasonBuilder extends WithholdingTaxReason, RosettaModelObjectBuilder {
		WithholdingTaxReason.WithholdingTaxReasonBuilder setValue(String value);
		WithholdingTaxReason.WithholdingTaxReasonBuilder setWithholdingTaxReasonScheme(String withholdingTaxReasonScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("withholdingTaxReasonScheme"), String.class, getWithholdingTaxReasonScheme(), this);
		}
		

		WithholdingTaxReason.WithholdingTaxReasonBuilder prune();
	}

	/*********************** Immutable Implementation of WithholdingTaxReason  ***********************/
	class WithholdingTaxReasonImpl implements WithholdingTaxReason {
		private final String value;
		private final String withholdingTaxReasonScheme;
		
		protected WithholdingTaxReasonImpl(WithholdingTaxReason.WithholdingTaxReasonBuilder builder) {
			this.value = builder.getValue();
			this.withholdingTaxReasonScheme = builder.getWithholdingTaxReasonScheme();
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
		@RosettaAttribute("withholdingTaxReasonScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withholdingTaxReasonScheme")
		public String getWithholdingTaxReasonScheme() {
			return withholdingTaxReasonScheme;
		}
		
		@Override
		public WithholdingTaxReason build() {
			return this;
		}
		
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder toBuilder() {
			WithholdingTaxReason.WithholdingTaxReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WithholdingTaxReason.WithholdingTaxReasonBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWithholdingTaxReasonScheme()).ifPresent(builder::setWithholdingTaxReasonScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithholdingTaxReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(withholdingTaxReasonScheme, _that.getWithholdingTaxReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (withholdingTaxReasonScheme != null ? withholdingTaxReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithholdingTaxReason {" +
				"value=" + this.value + ", " +
				"withholdingTaxReasonScheme=" + this.withholdingTaxReasonScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of WithholdingTaxReason  ***********************/
	class WithholdingTaxReasonBuilderImpl implements WithholdingTaxReason.WithholdingTaxReasonBuilder {
	
		protected String value;
		protected String withholdingTaxReasonScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("withholdingTaxReasonScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withholdingTaxReasonScheme")
		public String getWithholdingTaxReasonScheme() {
			return withholdingTaxReasonScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("withholdingTaxReasonScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withholdingTaxReasonScheme")
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder setWithholdingTaxReasonScheme(String _withholdingTaxReasonScheme) {
			this.withholdingTaxReasonScheme = _withholdingTaxReasonScheme == null ? null : _withholdingTaxReasonScheme;
			return this;
		}
		
		@Override
		public WithholdingTaxReason build() {
			return new WithholdingTaxReason.WithholdingTaxReasonImpl(this);
		}
		
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWithholdingTaxReasonScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WithholdingTaxReason.WithholdingTaxReasonBuilder o = (WithholdingTaxReason.WithholdingTaxReasonBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWithholdingTaxReasonScheme(), o.getWithholdingTaxReasonScheme(), this::setWithholdingTaxReasonScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithholdingTaxReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(withholdingTaxReasonScheme, _that.getWithholdingTaxReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (withholdingTaxReasonScheme != null ? withholdingTaxReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithholdingTaxReasonBuilder {" +
				"value=" + this.value + ", " +
				"withholdingTaxReasonScheme=" + this.withholdingTaxReasonScheme +
			'}';
		}
	}
}
