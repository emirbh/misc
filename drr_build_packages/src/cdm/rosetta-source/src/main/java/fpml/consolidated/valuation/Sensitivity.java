package fpml.consolidated.valuation;

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
import fpml.consolidated.valuation.meta.SensitivityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The sensitivity of a value to a defined change in input parameters.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The sensitivity of a value to a defined change in input parameters.
 *
 */
@RosettaDataType(value="Sensitivity", builder=Sensitivity.SensitivityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Sensitivity", model="fpml", builder=Sensitivity.SensitivityBuilderImpl.class, version="2.1.1")
public interface Sensitivity extends RosettaModelObject {

	SensitivityMeta metaData = new SensitivityMeta();

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
	BigDecimal getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A optional name for this sensitivity. This is primarily intended for display purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A optional name for this sensitivity. This is primarily intended for display purposes.
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A optional (but normally supplied) reference to the definition of this sensitivity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A optional (but normally supplied) reference to the definition of this sensitivity.
	 *
	 */
	String getDefinitionRef();

	/*********************** Build Methods  ***********************/
	Sensitivity build();
	
	Sensitivity.SensitivityBuilder toBuilder();
	
	static Sensitivity.SensitivityBuilder builder() {
		return new Sensitivity.SensitivityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Sensitivity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Sensitivity> getType() {
		return Sensitivity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityBuilder extends Sensitivity, RosettaModelObjectBuilder {
		Sensitivity.SensitivityBuilder setValue(BigDecimal value);
		Sensitivity.SensitivityBuilder setName(String name);
		Sensitivity.SensitivityBuilder setDefinitionRef(String definitionRef);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		}
		

		Sensitivity.SensitivityBuilder prune();
	}

	/*********************** Immutable Implementation of Sensitivity  ***********************/
	class SensitivityImpl implements Sensitivity {
		private final BigDecimal value;
		private final String name;
		private final String definitionRef;
		
		protected SensitivityImpl(Sensitivity.SensitivityBuilder builder) {
			this.value = builder.getValue();
			this.name = builder.getName();
			this.definitionRef = builder.getDefinitionRef();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@Override
		public Sensitivity build() {
			return this;
		}
		
		@Override
		public Sensitivity.SensitivityBuilder toBuilder() {
			Sensitivity.SensitivityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Sensitivity.SensitivityBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getDefinitionRef()).ifPresent(builder::setDefinitionRef);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sensitivity _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Sensitivity {" +
				"value=" + this.value + ", " +
				"name=" + this.name + ", " +
				"definitionRef=" + this.definitionRef +
			'}';
		}
	}

	/*********************** Builder Implementation of Sensitivity  ***********************/
	class SensitivityBuilderImpl implements Sensitivity.SensitivityBuilder {
	
		protected BigDecimal value;
		protected String name;
		protected String definitionRef;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("definitionRef")
		public String getDefinitionRef() {
			return definitionRef;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public Sensitivity.SensitivityBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public Sensitivity.SensitivityBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public Sensitivity.SensitivityBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@Override
		public Sensitivity build() {
			return new Sensitivity.SensitivityImpl(this);
		}
		
		@Override
		public Sensitivity.SensitivityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sensitivity.SensitivityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getName()!=null) return true;
			if (getDefinitionRef()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sensitivity.SensitivityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Sensitivity.SensitivityBuilder o = (Sensitivity.SensitivityBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getDefinitionRef(), o.getDefinitionRef(), this::setDefinitionRef);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sensitivity _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(definitionRef, _that.getDefinitionRef())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (definitionRef != null ? definitionRef.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityBuilder {" +
				"value=" + this.value + ", " +
				"name=" + this.name + ", " +
				"definitionRef=" + this.definitionRef +
			'}';
		}
	}
}
