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
import fpml.consolidated.loan.meta.DateAdjustmentTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a date adjustment type, based on a business case (e.g. grace days).
 *
 */
@RosettaDataType(value="DateAdjustmentType", builder=DateAdjustmentType.DateAdjustmentTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DateAdjustmentType", model="fpml", builder=DateAdjustmentType.DateAdjustmentTypeBuilderImpl.class, version="2.1.1")
public interface DateAdjustmentType extends RosettaModelObject {

	DateAdjustmentTypeMeta metaData = new DateAdjustmentTypeMeta();

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
	String getDateAdjustmentTypeScheme();

	/*********************** Build Methods  ***********************/
	DateAdjustmentType build();
	
	DateAdjustmentType.DateAdjustmentTypeBuilder toBuilder();
	
	static DateAdjustmentType.DateAdjustmentTypeBuilder builder() {
		return new DateAdjustmentType.DateAdjustmentTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateAdjustmentType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateAdjustmentType> getType() {
		return DateAdjustmentType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("dateAdjustmentTypeScheme"), String.class, getDateAdjustmentTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateAdjustmentTypeBuilder extends DateAdjustmentType, RosettaModelObjectBuilder {
		DateAdjustmentType.DateAdjustmentTypeBuilder setValue(String value);
		DateAdjustmentType.DateAdjustmentTypeBuilder setDateAdjustmentTypeScheme(String dateAdjustmentTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("dateAdjustmentTypeScheme"), String.class, getDateAdjustmentTypeScheme(), this);
		}
		

		DateAdjustmentType.DateAdjustmentTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DateAdjustmentType  ***********************/
	class DateAdjustmentTypeImpl implements DateAdjustmentType {
		private final String value;
		private final String dateAdjustmentTypeScheme;
		
		protected DateAdjustmentTypeImpl(DateAdjustmentType.DateAdjustmentTypeBuilder builder) {
			this.value = builder.getValue();
			this.dateAdjustmentTypeScheme = builder.getDateAdjustmentTypeScheme();
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
		@RosettaAttribute("dateAdjustmentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustmentTypeScheme")
		public String getDateAdjustmentTypeScheme() {
			return dateAdjustmentTypeScheme;
		}
		
		@Override
		public DateAdjustmentType build() {
			return this;
		}
		
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder toBuilder() {
			DateAdjustmentType.DateAdjustmentTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateAdjustmentType.DateAdjustmentTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDateAdjustmentTypeScheme()).ifPresent(builder::setDateAdjustmentTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateAdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dateAdjustmentTypeScheme, _that.getDateAdjustmentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentTypeScheme != null ? dateAdjustmentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateAdjustmentType {" +
				"value=" + this.value + ", " +
				"dateAdjustmentTypeScheme=" + this.dateAdjustmentTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DateAdjustmentType  ***********************/
	class DateAdjustmentTypeBuilderImpl implements DateAdjustmentType.DateAdjustmentTypeBuilder {
	
		protected String value;
		protected String dateAdjustmentTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("dateAdjustmentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustmentTypeScheme")
		public String getDateAdjustmentTypeScheme() {
			return dateAdjustmentTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("dateAdjustmentTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustmentTypeScheme")
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder setDateAdjustmentTypeScheme(String _dateAdjustmentTypeScheme) {
			this.dateAdjustmentTypeScheme = _dateAdjustmentTypeScheme == null ? null : _dateAdjustmentTypeScheme;
			return this;
		}
		
		@Override
		public DateAdjustmentType build() {
			return new DateAdjustmentType.DateAdjustmentTypeImpl(this);
		}
		
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDateAdjustmentTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateAdjustmentType.DateAdjustmentTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateAdjustmentType.DateAdjustmentTypeBuilder o = (DateAdjustmentType.DateAdjustmentTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDateAdjustmentTypeScheme(), o.getDateAdjustmentTypeScheme(), this::setDateAdjustmentTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateAdjustmentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dateAdjustmentTypeScheme, _that.getDateAdjustmentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentTypeScheme != null ? dateAdjustmentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateAdjustmentTypeBuilder {" +
				"value=" + this.value + ", " +
				"dateAdjustmentTypeScheme=" + this.dateAdjustmentTypeScheme +
			'}';
		}
	}
}
