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
import fpml.consolidated.loan.meta.CovenantObligationIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines a covenant obligation identifier based on a qualifying scheme.
 *
 */
@RosettaDataType(value="CovenantObligationId", builder=CovenantObligationId.CovenantObligationIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CovenantObligationId", model="fpml", builder=CovenantObligationId.CovenantObligationIdBuilderImpl.class, version="2.1.1")
public interface CovenantObligationId extends RosettaModelObject {

	CovenantObligationIdMeta metaData = new CovenantObligationIdMeta();

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
	String getCovenantObligationIdScheme();
	/**
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
	CovenantObligationId build();
	
	CovenantObligationId.CovenantObligationIdBuilder toBuilder();
	
	static CovenantObligationId.CovenantObligationIdBuilder builder() {
		return new CovenantObligationId.CovenantObligationIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CovenantObligationId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CovenantObligationId> getType() {
		return CovenantObligationId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("covenantObligationIdScheme"), String.class, getCovenantObligationIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CovenantObligationIdBuilder extends CovenantObligationId, RosettaModelObjectBuilder {
		CovenantObligationId.CovenantObligationIdBuilder setValue(String value);
		CovenantObligationId.CovenantObligationIdBuilder setCovenantObligationIdScheme(String covenantObligationIdScheme);
		CovenantObligationId.CovenantObligationIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("covenantObligationIdScheme"), String.class, getCovenantObligationIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CovenantObligationId.CovenantObligationIdBuilder prune();
	}

	/*********************** Immutable Implementation of CovenantObligationId  ***********************/
	class CovenantObligationIdImpl implements CovenantObligationId {
		private final String value;
		private final String covenantObligationIdScheme;
		private final String id;
		
		protected CovenantObligationIdImpl(CovenantObligationId.CovenantObligationIdBuilder builder) {
			this.value = builder.getValue();
			this.covenantObligationIdScheme = builder.getCovenantObligationIdScheme();
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
		@RosettaAttribute("covenantObligationIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantObligationIdScheme")
		public String getCovenantObligationIdScheme() {
			return covenantObligationIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CovenantObligationId build() {
			return this;
		}
		
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder toBuilder() {
			CovenantObligationId.CovenantObligationIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CovenantObligationId.CovenantObligationIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCovenantObligationIdScheme()).ifPresent(builder::setCovenantObligationIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CovenantObligationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(covenantObligationIdScheme, _that.getCovenantObligationIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (covenantObligationIdScheme != null ? covenantObligationIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationId {" +
				"value=" + this.value + ", " +
				"covenantObligationIdScheme=" + this.covenantObligationIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CovenantObligationId  ***********************/
	class CovenantObligationIdBuilderImpl implements CovenantObligationId.CovenantObligationIdBuilder {
	
		protected String value;
		protected String covenantObligationIdScheme;
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
		@RosettaAttribute("covenantObligationIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("covenantObligationIdScheme")
		public String getCovenantObligationIdScheme() {
			return covenantObligationIdScheme;
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
		public CovenantObligationId.CovenantObligationIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("covenantObligationIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("covenantObligationIdScheme")
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder setCovenantObligationIdScheme(String _covenantObligationIdScheme) {
			this.covenantObligationIdScheme = _covenantObligationIdScheme == null ? null : _covenantObligationIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public CovenantObligationId build() {
			return new CovenantObligationId.CovenantObligationIdImpl(this);
		}
		
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCovenantObligationIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CovenantObligationId.CovenantObligationIdBuilder o = (CovenantObligationId.CovenantObligationIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCovenantObligationIdScheme(), o.getCovenantObligationIdScheme(), this::setCovenantObligationIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CovenantObligationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(covenantObligationIdScheme, _that.getCovenantObligationIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (covenantObligationIdScheme != null ? covenantObligationIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationIdBuilder {" +
				"value=" + this.value + ", " +
				"covenantObligationIdScheme=" + this.covenantObligationIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
