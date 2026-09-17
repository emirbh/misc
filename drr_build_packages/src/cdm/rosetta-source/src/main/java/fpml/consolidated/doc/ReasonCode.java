package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ReasonCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines a list of machine interpretable error codes.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a list of machine interpretable error codes.
 *
 */
@RosettaDataType(value="ReasonCode", builder=ReasonCode.ReasonCodeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReasonCode", model="fpml", builder=ReasonCode.ReasonCodeBuilderImpl.class, version="2.1.1")
public interface ReasonCode extends RosettaModelObject {

	ReasonCodeMeta metaData = new ReasonCodeMeta();

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
	String getReasonCodeScheme();

	/*********************** Build Methods  ***********************/
	ReasonCode build();
	
	ReasonCode.ReasonCodeBuilder toBuilder();
	
	static ReasonCode.ReasonCodeBuilder builder() {
		return new ReasonCode.ReasonCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReasonCode> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReasonCode> getType() {
		return ReasonCode.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reasonCodeScheme"), String.class, getReasonCodeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReasonCodeBuilder extends ReasonCode, RosettaModelObjectBuilder {
		ReasonCode.ReasonCodeBuilder setValue(String value);
		ReasonCode.ReasonCodeBuilder setReasonCodeScheme(String reasonCodeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reasonCodeScheme"), String.class, getReasonCodeScheme(), this);
		}
		

		ReasonCode.ReasonCodeBuilder prune();
	}

	/*********************** Immutable Implementation of ReasonCode  ***********************/
	class ReasonCodeImpl implements ReasonCode {
		private final String value;
		private final String reasonCodeScheme;
		
		protected ReasonCodeImpl(ReasonCode.ReasonCodeBuilder builder) {
			this.value = builder.getValue();
			this.reasonCodeScheme = builder.getReasonCodeScheme();
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
		@RosettaAttribute("reasonCodeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reasonCodeScheme")
		public String getReasonCodeScheme() {
			return reasonCodeScheme;
		}
		
		@Override
		public ReasonCode build() {
			return this;
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder toBuilder() {
			ReasonCode.ReasonCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReasonCode.ReasonCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReasonCodeScheme()).ifPresent(builder::setReasonCodeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReasonCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reasonCodeScheme, _that.getReasonCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reasonCodeScheme != null ? reasonCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonCode {" +
				"value=" + this.value + ", " +
				"reasonCodeScheme=" + this.reasonCodeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReasonCode  ***********************/
	class ReasonCodeBuilderImpl implements ReasonCode.ReasonCodeBuilder {
	
		protected String value;
		protected String reasonCodeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reasonCodeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reasonCodeScheme")
		public String getReasonCodeScheme() {
			return reasonCodeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ReasonCode.ReasonCodeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("reasonCodeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reasonCodeScheme")
		@Override
		public ReasonCode.ReasonCodeBuilder setReasonCodeScheme(String _reasonCodeScheme) {
			this.reasonCodeScheme = _reasonCodeScheme == null ? null : _reasonCodeScheme;
			return this;
		}
		
		@Override
		public ReasonCode build() {
			return new ReasonCode.ReasonCodeImpl(this);
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReasonCode.ReasonCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReasonCodeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReasonCode.ReasonCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReasonCode.ReasonCodeBuilder o = (ReasonCode.ReasonCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReasonCodeScheme(), o.getReasonCodeScheme(), this::setReasonCodeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReasonCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reasonCodeScheme, _that.getReasonCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reasonCodeScheme != null ? reasonCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonCodeBuilder {" +
				"value=" + this.value + ", " +
				"reasonCodeScheme=" + this.reasonCodeScheme +
			'}';
		}
	}
}
