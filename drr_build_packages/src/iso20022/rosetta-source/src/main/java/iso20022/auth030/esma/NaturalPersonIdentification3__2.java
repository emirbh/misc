package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.NaturalPersonIdentification3__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies a natural person through identification number, name and domicile.
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification3__2", builder=NaturalPersonIdentification3__2.NaturalPersonIdentification3__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification3__2", model="iso20022", builder=NaturalPersonIdentification3__2.NaturalPersonIdentification3__2BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification3__2 extends RosettaModelObject {

	NaturalPersonIdentification3__2Meta metaData = new NaturalPersonIdentification3__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the natural person.
	 */
	NaturalPersonIdentification2__1 getId();
	/**
	 * Code of country of residence of a natural person.
	 */
	String getCtry();

	/*********************** Build Methods  ***********************/
	NaturalPersonIdentification3__2 build();
	
	NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder toBuilder();
	
	static NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder builder() {
		return new NaturalPersonIdentification3__2.NaturalPersonIdentification3__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPersonIdentification3__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPersonIdentification3__2> getType() {
		return NaturalPersonIdentification3__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.class, getId());
		processor.processBasic(path.newSubPath("ctry"), String.class, getCtry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification3__2Builder extends NaturalPersonIdentification3__2, RosettaModelObjectBuilder {
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateId();
		@Override
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getId();
		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setId(NaturalPersonIdentification2__1 id);
		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setCtry(String ctry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder.class, getId());
			processor.processBasic(path.newSubPath("ctry"), String.class, getCtry(), this);
		}
		

		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification3__2  ***********************/
	class NaturalPersonIdentification3__2Impl implements NaturalPersonIdentification3__2 {
		private final NaturalPersonIdentification2__1 id;
		private final String ctry;
		
		protected NaturalPersonIdentification3__2Impl(NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.ctry = builder.getCtry();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public NaturalPersonIdentification2__1 getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctry")
		public String getCtry() {
			return ctry;
		}
		
		@Override
		public NaturalPersonIdentification3__2 build() {
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder toBuilder() {
			NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCtry()).ifPresent(builder::setCtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ctry, _that.getCtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ctry != null ? ctry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification3__2 {" +
				"id=" + this.id + ", " +
				"ctry=" + this.ctry +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification3__2  ***********************/
	class NaturalPersonIdentification3__2BuilderImpl implements NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder {
	
		protected NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder id;
		protected String ctry;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getId() {
			return id;
		}
		
		@Override
		public NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateId() {
			NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = NaturalPersonIdentification2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctry")
		public String getCtry() {
			return ctry;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setId(NaturalPersonIdentification2__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ctry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctry")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setCtry(String _ctry) {
			this.ctry = _ctry == null ? null : _ctry;
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__2 build() {
			return new NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Impl(this);
		}
		
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getCtry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder o = (NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			merger.mergeBasic(getCtry(), o.getCtry(), this::setCtry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ctry, _that.getCtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ctry != null ? ctry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification3__2Builder {" +
				"id=" + this.id + ", " +
				"ctry=" + this.ctry +
			'}';
		}
	}
}
