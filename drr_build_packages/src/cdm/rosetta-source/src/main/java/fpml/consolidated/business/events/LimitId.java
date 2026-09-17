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
import fpml.consolidated.business.events.meta.LimitIdMeta;
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
@RosettaDataType(value="LimitId", builder=LimitId.LimitIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LimitId", model="fpml", builder=LimitId.LimitIdBuilderImpl.class, version="2.1.1")
public interface LimitId extends RosettaModelObject {

	LimitIdMeta metaData = new LimitIdMeta();

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
	String getCreditLimitIdScheme();

	/*********************** Build Methods  ***********************/
	LimitId build();
	
	LimitId.LimitIdBuilder toBuilder();
	
	static LimitId.LimitIdBuilder builder() {
		return new LimitId.LimitIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LimitId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LimitId> getType() {
		return LimitId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditLimitIdScheme"), String.class, getCreditLimitIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LimitIdBuilder extends LimitId, RosettaModelObjectBuilder {
		LimitId.LimitIdBuilder setValue(String value);
		LimitId.LimitIdBuilder setCreditLimitIdScheme(String creditLimitIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditLimitIdScheme"), String.class, getCreditLimitIdScheme(), this);
		}
		

		LimitId.LimitIdBuilder prune();
	}

	/*********************** Immutable Implementation of LimitId  ***********************/
	class LimitIdImpl implements LimitId {
		private final String value;
		private final String creditLimitIdScheme;
		
		protected LimitIdImpl(LimitId.LimitIdBuilder builder) {
			this.value = builder.getValue();
			this.creditLimitIdScheme = builder.getCreditLimitIdScheme();
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
		@RosettaAttribute("creditLimitIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditLimitIdScheme")
		public String getCreditLimitIdScheme() {
			return creditLimitIdScheme;
		}
		
		@Override
		public LimitId build() {
			return this;
		}
		
		@Override
		public LimitId.LimitIdBuilder toBuilder() {
			LimitId.LimitIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitId.LimitIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditLimitIdScheme()).ifPresent(builder::setCreditLimitIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitIdScheme, _that.getCreditLimitIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitIdScheme != null ? creditLimitIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitId {" +
				"value=" + this.value + ", " +
				"creditLimitIdScheme=" + this.creditLimitIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LimitId  ***********************/
	class LimitIdBuilderImpl implements LimitId.LimitIdBuilder {
	
		protected String value;
		protected String creditLimitIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditLimitIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditLimitIdScheme")
		public String getCreditLimitIdScheme() {
			return creditLimitIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LimitId.LimitIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("creditLimitIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditLimitIdScheme")
		@Override
		public LimitId.LimitIdBuilder setCreditLimitIdScheme(String _creditLimitIdScheme) {
			this.creditLimitIdScheme = _creditLimitIdScheme == null ? null : _creditLimitIdScheme;
			return this;
		}
		
		@Override
		public LimitId build() {
			return new LimitId.LimitIdImpl(this);
		}
		
		@Override
		public LimitId.LimitIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitId.LimitIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditLimitIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitId.LimitIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LimitId.LimitIdBuilder o = (LimitId.LimitIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditLimitIdScheme(), o.getCreditLimitIdScheme(), this::setCreditLimitIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitIdScheme, _that.getCreditLimitIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitIdScheme != null ? creditLimitIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitIdBuilder {" +
				"value=" + this.value + ", " +
				"creditLimitIdScheme=" + this.creditLimitIdScheme +
			'}';
		}
	}
}
