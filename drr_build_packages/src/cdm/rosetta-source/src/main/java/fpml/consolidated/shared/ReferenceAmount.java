package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.ReferenceAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies the reference amount using a scheme.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies the reference amount using a scheme.
 *
 */
@RosettaDataType(value="ReferenceAmount", builder=ReferenceAmount.ReferenceAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReferenceAmount", model="fpml", builder=ReferenceAmount.ReferenceAmountBuilderImpl.class, version="2.1.1")
public interface ReferenceAmount extends RosettaModelObject {

	ReferenceAmountMeta metaData = new ReferenceAmountMeta();

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
	String getValue();
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
	String getReferenceAmountScheme();

	/*********************** Build Methods  ***********************/
	ReferenceAmount build();
	
	ReferenceAmount.ReferenceAmountBuilder toBuilder();
	
	static ReferenceAmount.ReferenceAmountBuilder builder() {
		return new ReferenceAmount.ReferenceAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReferenceAmount> getType() {
		return ReferenceAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("referenceAmountScheme"), String.class, getReferenceAmountScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceAmountBuilder extends ReferenceAmount, RosettaModelObjectBuilder {
		ReferenceAmount.ReferenceAmountBuilder setValue(String value);
		ReferenceAmount.ReferenceAmountBuilder setReferenceAmountScheme(String referenceAmountScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("referenceAmountScheme"), String.class, getReferenceAmountScheme(), this);
		}
		

		ReferenceAmount.ReferenceAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceAmount  ***********************/
	class ReferenceAmountImpl implements ReferenceAmount {
		private final String value;
		private final String referenceAmountScheme;
		
		protected ReferenceAmountImpl(ReferenceAmount.ReferenceAmountBuilder builder) {
			this.value = builder.getValue();
			this.referenceAmountScheme = builder.getReferenceAmountScheme();
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
		@RosettaAttribute("referenceAmountScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmountScheme")
		public String getReferenceAmountScheme() {
			return referenceAmountScheme;
		}
		
		@Override
		public ReferenceAmount build() {
			return this;
		}
		
		@Override
		public ReferenceAmount.ReferenceAmountBuilder toBuilder() {
			ReferenceAmount.ReferenceAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceAmount.ReferenceAmountBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReferenceAmountScheme()).ifPresent(builder::setReferenceAmountScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(referenceAmountScheme, _that.getReferenceAmountScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (referenceAmountScheme != null ? referenceAmountScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceAmount {" +
				"value=" + this.value + ", " +
				"referenceAmountScheme=" + this.referenceAmountScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceAmount  ***********************/
	class ReferenceAmountBuilderImpl implements ReferenceAmount.ReferenceAmountBuilder {
	
		protected String value;
		protected String referenceAmountScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("referenceAmountScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmountScheme")
		public String getReferenceAmountScheme() {
			return referenceAmountScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ReferenceAmount.ReferenceAmountBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("referenceAmountScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceAmountScheme")
		@Override
		public ReferenceAmount.ReferenceAmountBuilder setReferenceAmountScheme(String _referenceAmountScheme) {
			this.referenceAmountScheme = _referenceAmountScheme == null ? null : _referenceAmountScheme;
			return this;
		}
		
		@Override
		public ReferenceAmount build() {
			return new ReferenceAmount.ReferenceAmountImpl(this);
		}
		
		@Override
		public ReferenceAmount.ReferenceAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceAmount.ReferenceAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReferenceAmountScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceAmount.ReferenceAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceAmount.ReferenceAmountBuilder o = (ReferenceAmount.ReferenceAmountBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReferenceAmountScheme(), o.getReferenceAmountScheme(), this::setReferenceAmountScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(referenceAmountScheme, _that.getReferenceAmountScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (referenceAmountScheme != null ? referenceAmountScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceAmountBuilder {" +
				"value=" + this.value + ", " +
				"referenceAmountScheme=" + this.referenceAmountScheme +
			'}';
		}
	}
}
