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
import fpml.consolidated.loan.meta.AssociationToAssetIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines an association identifier based on a qualifying scheme.
 *
 */
@RosettaDataType(value="AssociationToAssetId", builder=AssociationToAssetId.AssociationToAssetIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AssociationToAssetId", model="fpml", builder=AssociationToAssetId.AssociationToAssetIdBuilderImpl.class, version="2.1.1")
public interface AssociationToAssetId extends RosettaModelObject {

	AssociationToAssetIdMeta metaData = new AssociationToAssetIdMeta();

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
	String getAssociationToAssetIdScheme();
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
	AssociationToAssetId build();
	
	AssociationToAssetId.AssociationToAssetIdBuilder toBuilder();
	
	static AssociationToAssetId.AssociationToAssetIdBuilder builder() {
		return new AssociationToAssetId.AssociationToAssetIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssociationToAssetId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssociationToAssetId> getType() {
		return AssociationToAssetId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("associationToAssetIdScheme"), String.class, getAssociationToAssetIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssociationToAssetIdBuilder extends AssociationToAssetId, RosettaModelObjectBuilder {
		AssociationToAssetId.AssociationToAssetIdBuilder setValue(String value);
		AssociationToAssetId.AssociationToAssetIdBuilder setAssociationToAssetIdScheme(String associationToAssetIdScheme);
		AssociationToAssetId.AssociationToAssetIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("associationToAssetIdScheme"), String.class, getAssociationToAssetIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AssociationToAssetId.AssociationToAssetIdBuilder prune();
	}

	/*********************** Immutable Implementation of AssociationToAssetId  ***********************/
	class AssociationToAssetIdImpl implements AssociationToAssetId {
		private final String value;
		private final String associationToAssetIdScheme;
		private final String id;
		
		protected AssociationToAssetIdImpl(AssociationToAssetId.AssociationToAssetIdBuilder builder) {
			this.value = builder.getValue();
			this.associationToAssetIdScheme = builder.getAssociationToAssetIdScheme();
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
		@RosettaAttribute("associationToAssetIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("associationToAssetIdScheme")
		public String getAssociationToAssetIdScheme() {
			return associationToAssetIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AssociationToAssetId build() {
			return this;
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder toBuilder() {
			AssociationToAssetId.AssociationToAssetIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssociationToAssetId.AssociationToAssetIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAssociationToAssetIdScheme()).ifPresent(builder::setAssociationToAssetIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(associationToAssetIdScheme, _that.getAssociationToAssetIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (associationToAssetIdScheme != null ? associationToAssetIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetId {" +
				"value=" + this.value + ", " +
				"associationToAssetIdScheme=" + this.associationToAssetIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AssociationToAssetId  ***********************/
	class AssociationToAssetIdBuilderImpl implements AssociationToAssetId.AssociationToAssetIdBuilder {
	
		protected String value;
		protected String associationToAssetIdScheme;
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
		@RosettaAttribute("associationToAssetIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("associationToAssetIdScheme")
		public String getAssociationToAssetIdScheme() {
			return associationToAssetIdScheme;
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
		public AssociationToAssetId.AssociationToAssetIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("associationToAssetIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("associationToAssetIdScheme")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder setAssociationToAssetIdScheme(String _associationToAssetIdScheme) {
			this.associationToAssetIdScheme = _associationToAssetIdScheme == null ? null : _associationToAssetIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public AssociationToAssetId build() {
			return new AssociationToAssetId.AssociationToAssetIdImpl(this);
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAssociationToAssetIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssociationToAssetId.AssociationToAssetIdBuilder o = (AssociationToAssetId.AssociationToAssetIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAssociationToAssetIdScheme(), o.getAssociationToAssetIdScheme(), this::setAssociationToAssetIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(associationToAssetIdScheme, _that.getAssociationToAssetIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (associationToAssetIdScheme != null ? associationToAssetIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdBuilder {" +
				"value=" + this.value + ", " +
				"associationToAssetIdScheme=" + this.associationToAssetIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
