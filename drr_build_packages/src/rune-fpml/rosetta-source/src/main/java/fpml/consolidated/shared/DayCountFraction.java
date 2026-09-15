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
import fpml.consolidated.shared.meta.DayCountFractionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification for how the number of days between two dates is calculated for purposes of calculation of a fixed or floating payment amount and the basis for how many days are assumed to be in a year. Day Count Fraction is an ISDA term. The equivalent AFB (Association Francaise de Banques) term is Calculation Basis.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification for how the number of days between two dates is calculated for purposes of calculation of a fixed or floating payment amount and the basis for how many days are assumed to be in a year. Day Count Fraction is an ISDA term. The equivalent AFB (Association Francaise de Banques) term is Calculation Basis.
 *
 */
@RosettaDataType(value="DayCountFraction", builder=DayCountFraction.DayCountFractionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DayCountFraction", model="fpml", builder=DayCountFraction.DayCountFractionBuilderImpl.class, version="2.1.1")
public interface DayCountFraction extends RosettaModelObject {

	DayCountFractionMeta metaData = new DayCountFractionMeta();

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
	String getDayCountFractionScheme();

	/*********************** Build Methods  ***********************/
	DayCountFraction build();
	
	DayCountFraction.DayCountFractionBuilder toBuilder();
	
	static DayCountFraction.DayCountFractionBuilder builder() {
		return new DayCountFraction.DayCountFractionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DayCountFraction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DayCountFraction> getType() {
		return DayCountFraction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("dayCountFractionScheme"), String.class, getDayCountFractionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DayCountFractionBuilder extends DayCountFraction, RosettaModelObjectBuilder {
		DayCountFraction.DayCountFractionBuilder setValue(String value);
		DayCountFraction.DayCountFractionBuilder setDayCountFractionScheme(String dayCountFractionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("dayCountFractionScheme"), String.class, getDayCountFractionScheme(), this);
		}
		

		DayCountFraction.DayCountFractionBuilder prune();
	}

	/*********************** Immutable Implementation of DayCountFraction  ***********************/
	class DayCountFractionImpl implements DayCountFraction {
		private final String value;
		private final String dayCountFractionScheme;
		
		protected DayCountFractionImpl(DayCountFraction.DayCountFractionBuilder builder) {
			this.value = builder.getValue();
			this.dayCountFractionScheme = builder.getDayCountFractionScheme();
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
		@RosettaAttribute("dayCountFractionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFractionScheme")
		public String getDayCountFractionScheme() {
			return dayCountFractionScheme;
		}
		
		@Override
		public DayCountFraction build() {
			return this;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder toBuilder() {
			DayCountFraction.DayCountFractionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DayCountFraction.DayCountFractionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDayCountFractionScheme()).ifPresent(builder::setDayCountFractionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DayCountFraction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dayCountFractionScheme, _that.getDayCountFractionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dayCountFractionScheme != null ? dayCountFractionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DayCountFraction {" +
				"value=" + this.value + ", " +
				"dayCountFractionScheme=" + this.dayCountFractionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DayCountFraction  ***********************/
	class DayCountFractionBuilderImpl implements DayCountFraction.DayCountFractionBuilder {
	
		protected String value;
		protected String dayCountFractionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("dayCountFractionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFractionScheme")
		public String getDayCountFractionScheme() {
			return dayCountFractionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DayCountFraction.DayCountFractionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("dayCountFractionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFractionScheme")
		@Override
		public DayCountFraction.DayCountFractionBuilder setDayCountFractionScheme(String _dayCountFractionScheme) {
			this.dayCountFractionScheme = _dayCountFractionScheme == null ? null : _dayCountFractionScheme;
			return this;
		}
		
		@Override
		public DayCountFraction build() {
			return new DayCountFraction.DayCountFractionImpl(this);
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DayCountFraction.DayCountFractionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDayCountFractionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DayCountFraction.DayCountFractionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DayCountFraction.DayCountFractionBuilder o = (DayCountFraction.DayCountFractionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDayCountFractionScheme(), o.getDayCountFractionScheme(), this::setDayCountFractionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DayCountFraction _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(dayCountFractionScheme, _that.getDayCountFractionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (dayCountFractionScheme != null ? dayCountFractionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DayCountFractionBuilder {" +
				"value=" + this.value + ", " +
				"dayCountFractionScheme=" + this.dayCountFractionScheme +
			'}';
		}
	}
}
