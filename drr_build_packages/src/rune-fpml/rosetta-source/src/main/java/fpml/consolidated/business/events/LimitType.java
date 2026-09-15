package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.LimitTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LimitType", builder=LimitType.LimitTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LimitType", model="fpml", builder=LimitType.LimitTypeBuilderImpl.class, version="2.1.1")
public interface LimitType extends RosettaModelObject {

	LimitTypeMeta metaData = new LimitTypeMeta();

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
	String getCreditLimitTypeScheme();

	/*********************** Build Methods  ***********************/
	LimitType build();
	
	LimitType.LimitTypeBuilder toBuilder();
	
	static LimitType.LimitTypeBuilder builder() {
		return new LimitType.LimitTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LimitType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LimitType> getType() {
		return LimitType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditLimitTypeScheme"), String.class, getCreditLimitTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LimitTypeBuilder extends LimitType, RosettaModelObjectBuilder {
		LimitType.LimitTypeBuilder setValue(String value);
		LimitType.LimitTypeBuilder setCreditLimitTypeScheme(String creditLimitTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditLimitTypeScheme"), String.class, getCreditLimitTypeScheme(), this);
		}
		

		LimitType.LimitTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LimitType  ***********************/
	class LimitTypeImpl implements LimitType {
		private final String value;
		private final String creditLimitTypeScheme;
		
		protected LimitTypeImpl(LimitType.LimitTypeBuilder builder) {
			this.value = builder.getValue();
			this.creditLimitTypeScheme = builder.getCreditLimitTypeScheme();
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
		@RosettaAttribute("creditLimitTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditLimitTypeScheme")
		public String getCreditLimitTypeScheme() {
			return creditLimitTypeScheme;
		}
		
		@Override
		public LimitType build() {
			return this;
		}
		
		@Override
		public LimitType.LimitTypeBuilder toBuilder() {
			LimitType.LimitTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitType.LimitTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditLimitTypeScheme()).ifPresent(builder::setCreditLimitTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitTypeScheme, _that.getCreditLimitTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitTypeScheme != null ? creditLimitTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitType {" +
				"value=" + this.value + ", " +
				"creditLimitTypeScheme=" + this.creditLimitTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LimitType  ***********************/
	class LimitTypeBuilderImpl implements LimitType.LimitTypeBuilder {
	
		protected String value;
		protected String creditLimitTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditLimitTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditLimitTypeScheme")
		public String getCreditLimitTypeScheme() {
			return creditLimitTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LimitType.LimitTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("creditLimitTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditLimitTypeScheme")
		@Override
		public LimitType.LimitTypeBuilder setCreditLimitTypeScheme(String _creditLimitTypeScheme) {
			this.creditLimitTypeScheme = _creditLimitTypeScheme == null ? null : _creditLimitTypeScheme;
			return this;
		}
		
		@Override
		public LimitType build() {
			return new LimitType.LimitTypeImpl(this);
		}
		
		@Override
		public LimitType.LimitTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitType.LimitTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditLimitTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitType.LimitTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LimitType.LimitTypeBuilder o = (LimitType.LimitTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditLimitTypeScheme(), o.getCreditLimitTypeScheme(), this::setCreditLimitTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitTypeScheme, _that.getCreditLimitTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitTypeScheme != null ? creditLimitTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitTypeBuilder {" +
				"value=" + this.value + ", " +
				"creditLimitTypeScheme=" + this.creditLimitTypeScheme +
			'}';
		}
	}
}
