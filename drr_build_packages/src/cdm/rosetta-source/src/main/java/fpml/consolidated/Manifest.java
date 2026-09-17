package fpml.consolidated;

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
import fpml.consolidated.meta.ManifestMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
@RosettaDataType(value="Manifest", builder=Manifest.ManifestBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Manifest", model="fpml", builder=Manifest.ManifestBuilderImpl.class, version="2.1.1")
public interface Manifest extends ManifestType {

	ManifestMeta metaData = new ManifestMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Manifest build();
	
	Manifest.ManifestBuilder toBuilder();
	
	static Manifest.ManifestBuilder builder() {
		return new Manifest.ManifestBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Manifest> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Manifest> getType() {
		return Manifest.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("reference"), processor, ReferenceType.class, getReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ManifestBuilder extends Manifest, ManifestType.ManifestTypeBuilder {
		@Override
		Manifest.ManifestBuilder setId(String id);
		@Override
		Manifest.ManifestBuilder addReference(ReferenceType reference);
		@Override
		Manifest.ManifestBuilder addReference(ReferenceType reference, int idx);
		@Override
		Manifest.ManifestBuilder addReference(List<? extends ReferenceType> reference);
		@Override
		Manifest.ManifestBuilder setReference(List<? extends ReferenceType> reference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("reference"), processor, ReferenceType.ReferenceTypeBuilder.class, getReference());
		}
		

		Manifest.ManifestBuilder prune();
	}

	/*********************** Immutable Implementation of Manifest  ***********************/
	class ManifestImpl extends ManifestType.ManifestTypeImpl implements Manifest {
		
		protected ManifestImpl(Manifest.ManifestBuilder builder) {
			super(builder);
		}
		
		@Override
		public Manifest build() {
			return this;
		}
		
		@Override
		public Manifest.ManifestBuilder toBuilder() {
			Manifest.ManifestBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Manifest.ManifestBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Manifest {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Manifest  ***********************/
	class ManifestBuilderImpl extends ManifestType.ManifestTypeBuilderImpl implements Manifest.ManifestBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Manifest.ManifestBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("reference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("reference")
		@Override
		public Manifest.ManifestBuilder addReference(ReferenceType _reference) {
			if (_reference != null) {
				this.reference.add(_reference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Manifest.ManifestBuilder addReference(ReferenceType _reference, int idx) {
			getIndex(this.reference, idx, () -> _reference.toBuilder());
			return this;
		}
		
		@Override
		public Manifest.ManifestBuilder addReference(List<? extends ReferenceType> references) {
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
		public Manifest.ManifestBuilder setReference(List<? extends ReferenceType> references) {
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
		public Manifest build() {
			return new Manifest.ManifestImpl(this);
		}
		
		@Override
		public Manifest.ManifestBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Manifest.ManifestBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Manifest.ManifestBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Manifest.ManifestBuilder o = (Manifest.ManifestBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ManifestBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
