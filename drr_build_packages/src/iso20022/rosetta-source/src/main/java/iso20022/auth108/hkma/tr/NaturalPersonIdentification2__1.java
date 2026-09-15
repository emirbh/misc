package iso20022.auth108.hkma.tr;

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
import iso20022.auth108.hkma.tr.meta.NaturalPersonIdentification2__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies a natural person through identification number, name and domicile.
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification2__1", builder=NaturalPersonIdentification2__1.NaturalPersonIdentification2__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification2__1", model="iso20022", builder=NaturalPersonIdentification2__1.NaturalPersonIdentification2__1BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification2__1 extends RosettaModelObject {

	NaturalPersonIdentification2__1Meta metaData = new NaturalPersonIdentification2__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the natural person.
	 */
	GenericIdentification175__2 getId();

	/*********************** Build Methods  ***********************/
	NaturalPersonIdentification2__1 build();
	
	NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder toBuilder();
	
	static NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder builder() {
		return new NaturalPersonIdentification2__1.NaturalPersonIdentification2__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPersonIdentification2__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPersonIdentification2__1> getType() {
		return NaturalPersonIdentification2__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, GenericIdentification175__2.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification2__1Builder extends NaturalPersonIdentification2__1, RosettaModelObjectBuilder {
		GenericIdentification175__2.GenericIdentification175__2Builder getOrCreateId();
		@Override
		GenericIdentification175__2.GenericIdentification175__2Builder getId();
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder setId(GenericIdentification175__2 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, GenericIdentification175__2.GenericIdentification175__2Builder.class, getId());
		}
		

		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification2__1  ***********************/
	class NaturalPersonIdentification2__1Impl implements NaturalPersonIdentification2__1 {
		private final GenericIdentification175__2 id;
		
		protected NaturalPersonIdentification2__1Impl(NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__2 getId() {
			return id;
		}
		
		@Override
		public NaturalPersonIdentification2__1 build() {
			return this;
		}
		
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder toBuilder() {
			NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification2__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification2__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification2__1  ***********************/
	class NaturalPersonIdentification2__1BuilderImpl implements NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder {
	
		protected GenericIdentification175__2.GenericIdentification175__2Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__2.GenericIdentification175__2Builder getId() {
			return id;
		}
		
		@Override
		public GenericIdentification175__2.GenericIdentification175__2Builder getOrCreateId() {
			GenericIdentification175__2.GenericIdentification175__2Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = GenericIdentification175__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder setId(GenericIdentification175__2 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPersonIdentification2__1 build() {
			return new NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Impl(this);
		}
		
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder o = (NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification2__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification2__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
