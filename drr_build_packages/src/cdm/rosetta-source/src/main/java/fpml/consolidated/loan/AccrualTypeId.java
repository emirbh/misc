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
import fpml.consolidated.loan.meta.AccrualTypeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a single accrual type within a syndicated loan structure.
 *
 */
@RosettaDataType(value="AccrualTypeId", builder=AccrualTypeId.AccrualTypeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccrualTypeId", model="fpml", builder=AccrualTypeId.AccrualTypeIdBuilderImpl.class, version="2.1.1")
public interface AccrualTypeId extends RosettaModelObject {

	AccrualTypeIdMeta metaData = new AccrualTypeIdMeta();

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
	String getAccrualTypeIdScheme();

	/*********************** Build Methods  ***********************/
	AccrualTypeId build();
	
	AccrualTypeId.AccrualTypeIdBuilder toBuilder();
	
	static AccrualTypeId.AccrualTypeIdBuilder builder() {
		return new AccrualTypeId.AccrualTypeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualTypeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccrualTypeId> getType() {
		return AccrualTypeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accrualTypeIdScheme"), String.class, getAccrualTypeIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualTypeIdBuilder extends AccrualTypeId, RosettaModelObjectBuilder {
		AccrualTypeId.AccrualTypeIdBuilder setValue(String value);
		AccrualTypeId.AccrualTypeIdBuilder setAccrualTypeIdScheme(String accrualTypeIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accrualTypeIdScheme"), String.class, getAccrualTypeIdScheme(), this);
		}
		

		AccrualTypeId.AccrualTypeIdBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualTypeId  ***********************/
	class AccrualTypeIdImpl implements AccrualTypeId {
		private final String value;
		private final String accrualTypeIdScheme;
		
		protected AccrualTypeIdImpl(AccrualTypeId.AccrualTypeIdBuilder builder) {
			this.value = builder.getValue();
			this.accrualTypeIdScheme = builder.getAccrualTypeIdScheme();
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
		@RosettaAttribute("accrualTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualTypeIdScheme")
		public String getAccrualTypeIdScheme() {
			return accrualTypeIdScheme;
		}
		
		@Override
		public AccrualTypeId build() {
			return this;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder toBuilder() {
			AccrualTypeId.AccrualTypeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualTypeId.AccrualTypeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccrualTypeIdScheme()).ifPresent(builder::setAccrualTypeIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accrualTypeIdScheme, _that.getAccrualTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accrualTypeIdScheme != null ? accrualTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualTypeId {" +
				"value=" + this.value + ", " +
				"accrualTypeIdScheme=" + this.accrualTypeIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualTypeId  ***********************/
	class AccrualTypeIdBuilderImpl implements AccrualTypeId.AccrualTypeIdBuilder {
	
		protected String value;
		protected String accrualTypeIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accrualTypeIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accrualTypeIdScheme")
		public String getAccrualTypeIdScheme() {
			return accrualTypeIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("accrualTypeIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accrualTypeIdScheme")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder setAccrualTypeIdScheme(String _accrualTypeIdScheme) {
			this.accrualTypeIdScheme = _accrualTypeIdScheme == null ? null : _accrualTypeIdScheme;
			return this;
		}
		
		@Override
		public AccrualTypeId build() {
			return new AccrualTypeId.AccrualTypeIdImpl(this);
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccrualTypeIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualTypeId.AccrualTypeIdBuilder o = (AccrualTypeId.AccrualTypeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccrualTypeIdScheme(), o.getAccrualTypeIdScheme(), this::setAccrualTypeIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accrualTypeIdScheme, _that.getAccrualTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accrualTypeIdScheme != null ? accrualTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualTypeIdBuilder {" +
				"value=" + this.value + ", " +
				"accrualTypeIdScheme=" + this.accrualTypeIdScheme +
			'}';
		}
	}
}
