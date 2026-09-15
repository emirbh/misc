package fpml.consolidated;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.meta.ManifestTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="ManifestType", builder=ManifestType.ManifestTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ManifestType", model="fpml", builder=ManifestType.ManifestTypeBuilderImpl.class, version="2.1.1")
public interface ManifestType extends RosettaModelObject {

	ManifestTypeMeta metaData = new ManifestTypeMeta();

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
	String getId();
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
	List<? extends ReferenceType> getReference();

	/*********************** Build Methods  ***********************/
	ManifestType build();
	
	ManifestType.ManifestTypeBuilder toBuilder();
	
	static ManifestType.ManifestTypeBuilder builder() {
		return new ManifestType.ManifestTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ManifestType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ManifestType> getType() {
		return ManifestType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ManifestTypeBuilder extends ManifestType, RosettaModelObjectBuilder {
		ReferenceType.ReferenceTypeBuilder getOrCreateReference(int index);
		@Override
		List<? extends ReferenceType.ReferenceTypeBuilder> getReference();
		ManifestType.ManifestTypeBuilder setId(String id);
		ManifestType.ManifestTypeBuilder addReference(ReferenceType reference);
		ManifestType.ManifestTypeBuilder addReference(ReferenceType reference, int idx);
		ManifestType.ManifestTypeBuilder addReference(List<? extends ReferenceType> reference);
		ManifestType.ManifestTypeBuilder setReference(List<? extends ReferenceType> reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
		}
		

		ManifestType.ManifestTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ManifestType  ***********************/
	class ManifestTypeImpl implements ManifestType {
		private final String id;
		private final List<? extends ReferenceType> reference;
		
		protected ManifestTypeImpl(ManifestType.ManifestTypeBuilder builder) {
			this.id = builder.getId();
			this.reference = ofNullable(builder.getReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("reference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		public List<? extends ReferenceType> getReference() {
			return reference;
		}
		
		@Override
		public ManifestType build() {
			return this;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder toBuilder() {
			ManifestType.ManifestTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ManifestType.ManifestTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getReference()).ifPresent(builder::setReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ManifestType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestType {" +
				"id=" + this.id + ", " +
				"reference=" + this.reference +
			'}';
		}
	}

	/*********************** Builder Implementation of ManifestType  ***********************/
	class ManifestTypeBuilderImpl implements ManifestType.ManifestTypeBuilder {
	
		protected String id;
		protected List<ReferenceType.ReferenceTypeBuilder> reference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("reference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		public List<? extends ReferenceType.ReferenceTypeBuilder> getReference() {
			return reference;
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder getOrCreateReference(int index) {
			if (reference==null) {
				this.reference = new ArrayList<>();
			}
			return getIndex(reference, index, () -> {
						ReferenceType.ReferenceTypeBuilder newReference = ReferenceType.builder();
						return newReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ManifestType.ManifestTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public ManifestType.ManifestTypeBuilder addReference(ReferenceType _reference) {
			if (_reference != null) {
				this.reference.add(_reference.toBuilder());
			}
			return this;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder addReference(ReferenceType _reference, int idx) {
			getIndex(this.reference, idx, () -> _reference.toBuilder());
			return this;
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder addReference(List<? extends ReferenceType> references) {
			if (references != null) {
				for (final ReferenceType toAdd : references) {
					this.reference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public ManifestType.ManifestTypeBuilder setReference(List<? extends ReferenceType> references) {
			if (references == null) {
				this.reference = new ArrayList<>();
			} else {
				this.reference = references.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ManifestType build() {
			return new ManifestType.ManifestTypeImpl(this);
		}
		
		@Override
		public ManifestType.ManifestTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ManifestType.ManifestTypeBuilder prune() {
			reference = reference.stream().filter(b->b!=null).<ReferenceType.ReferenceTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getReference()!=null && getReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ManifestType.ManifestTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ManifestType.ManifestTypeBuilder o = (ManifestType.ManifestTypeBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::getOrCreateReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ManifestType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(reference, _that.getReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestTypeBuilder {" +
				"id=" + this.id + ", " +
				"reference=" + this.reference +
			'}';
		}
	}
}
