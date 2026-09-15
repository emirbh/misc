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
import fpml.consolidated.shared.meta.DeterminationMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Coding scheme that specifies the method according to which an amount or a date is determined.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Coding scheme that specifies the method according to which an amount or a date is determined.
 *
 */
@RosettaDataType(value="DeterminationMethod", builder=DeterminationMethod.DeterminationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DeterminationMethod", model="fpml", builder=DeterminationMethod.DeterminationMethodBuilderImpl.class, version="2.1.1")
public interface DeterminationMethod extends RosettaModelObject {

	DeterminationMethodMeta metaData = new DeterminationMethodMeta();

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
	String getDeterminationMethodScheme();
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
	String getId();

	/*********************** Build Methods  ***********************/
	DeterminationMethod build();
	
	DeterminationMethod.DeterminationMethodBuilder toBuilder();
	
	static DeterminationMethod.DeterminationMethodBuilder builder() {
		return new DeterminationMethod.DeterminationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeterminationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeterminationMethod> getType() {
		return DeterminationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("determinationMethodScheme"), String.class, getDeterminationMethodScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeterminationMethodBuilder extends DeterminationMethod, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder setValue(String value);
		DeterminationMethod.DeterminationMethodBuilder setDeterminationMethodScheme(String determinationMethodScheme);
		DeterminationMethod.DeterminationMethodBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("determinationMethodScheme"), String.class, getDeterminationMethodScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		DeterminationMethod.DeterminationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DeterminationMethod  ***********************/
	class DeterminationMethodImpl implements DeterminationMethod {
		private final String value;
		private final String determinationMethodScheme;
		private final String id;
		
		protected DeterminationMethodImpl(DeterminationMethod.DeterminationMethodBuilder builder) {
			this.value = builder.getValue();
			this.determinationMethodScheme = builder.getDeterminationMethodScheme();
			this.id = builder.getId();
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
		@RosettaAttribute("determinationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethodScheme")
		public String getDeterminationMethodScheme() {
			return determinationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public DeterminationMethod build() {
			return this;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder toBuilder() {
			DeterminationMethod.DeterminationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeterminationMethod.DeterminationMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeterminationMethodScheme()).ifPresent(builder::setDeterminationMethodScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(determinationMethodScheme, _that.getDeterminationMethodScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (determinationMethodScheme != null ? determinationMethodScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethod {" +
				"value=" + this.value + ", " +
				"determinationMethodScheme=" + this.determinationMethodScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DeterminationMethod  ***********************/
	class DeterminationMethodBuilderImpl implements DeterminationMethod.DeterminationMethodBuilder {
	
		protected String value;
		protected String determinationMethodScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("determinationMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethodScheme")
		public String getDeterminationMethodScheme() {
			return determinationMethodScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("determinationMethodScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethodScheme")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder setDeterminationMethodScheme(String _determinationMethodScheme) {
			this.determinationMethodScheme = _determinationMethodScheme == null ? null : _determinationMethodScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public DeterminationMethod build() {
			return new DeterminationMethod.DeterminationMethodImpl(this);
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeterminationMethodScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethod.DeterminationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeterminationMethod.DeterminationMethodBuilder o = (DeterminationMethod.DeterminationMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeterminationMethodScheme(), o.getDeterminationMethodScheme(), this::setDeterminationMethodScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(determinationMethodScheme, _that.getDeterminationMethodScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (determinationMethodScheme != null ? determinationMethodScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodBuilder {" +
				"value=" + this.value + ", " +
				"determinationMethodScheme=" + this.determinationMethodScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
