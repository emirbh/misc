package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.NaturalPersonIdentification2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies a natural person through identification number, name and domicile.
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification2", builder=NaturalPersonIdentification2.NaturalPersonIdentification2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification2", model="iso20022", builder=NaturalPersonIdentification2.NaturalPersonIdentification2BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification2 extends RosettaModelObject {

	NaturalPersonIdentification2Meta metaData = new NaturalPersonIdentification2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the natural person.
	 */
	GenericIdentification175 getId();
	/**
	 * Indicates the name of the natural person.
	 */
	String getNm();
	/**
	 * Indicates the domicile of the natural person.
	 */
	String getDmcl();

	/*********************** Build Methods  ***********************/
	NaturalPersonIdentification2 build();
	
	NaturalPersonIdentification2.NaturalPersonIdentification2Builder toBuilder();
	
	static NaturalPersonIdentification2.NaturalPersonIdentification2Builder builder() {
		return new NaturalPersonIdentification2.NaturalPersonIdentification2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPersonIdentification2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPersonIdentification2> getType() {
		return NaturalPersonIdentification2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, GenericIdentification175.class, getId());
		processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
		processor.processBasic(path.newSubPath("dmcl"), String.class, getDmcl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification2Builder extends NaturalPersonIdentification2, RosettaModelObjectBuilder {
		GenericIdentification175.GenericIdentification175Builder getOrCreateId();
		@Override
		GenericIdentification175.GenericIdentification175Builder getId();
		NaturalPersonIdentification2.NaturalPersonIdentification2Builder setId(GenericIdentification175 id);
		NaturalPersonIdentification2.NaturalPersonIdentification2Builder setNm(String nm);
		NaturalPersonIdentification2.NaturalPersonIdentification2Builder setDmcl(String dmcl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, GenericIdentification175.GenericIdentification175Builder.class, getId());
			processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
			processor.processBasic(path.newSubPath("dmcl"), String.class, getDmcl(), this);
		}
		

		NaturalPersonIdentification2.NaturalPersonIdentification2Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification2  ***********************/
	class NaturalPersonIdentification2Impl implements NaturalPersonIdentification2 {
		private final GenericIdentification175 id;
		private final String nm;
		private final String dmcl;
		
		protected NaturalPersonIdentification2Impl(NaturalPersonIdentification2.NaturalPersonIdentification2Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.nm = builder.getNm();
			this.dmcl = builder.getDmcl();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175 getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("dmcl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmcl")
		public String getDmcl() {
			return dmcl;
		}
		
		@Override
		public NaturalPersonIdentification2 build() {
			return this;
		}
		
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder toBuilder() {
			NaturalPersonIdentification2.NaturalPersonIdentification2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonIdentification2.NaturalPersonIdentification2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNm()).ifPresent(builder::setNm);
			ofNullable(getDmcl()).ifPresent(builder::setDmcl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(dmcl, _that.getDmcl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (dmcl != null ? dmcl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification2 {" +
				"id=" + this.id + ", " +
				"nm=" + this.nm + ", " +
				"dmcl=" + this.dmcl +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification2  ***********************/
	class NaturalPersonIdentification2BuilderImpl implements NaturalPersonIdentification2.NaturalPersonIdentification2Builder {
	
		protected GenericIdentification175.GenericIdentification175Builder id;
		protected String nm;
		protected String dmcl;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175.GenericIdentification175Builder getId() {
			return id;
		}
		
		@Override
		public GenericIdentification175.GenericIdentification175Builder getOrCreateId() {
			GenericIdentification175.GenericIdentification175Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = GenericIdentification175.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("dmcl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmcl")
		public String getDmcl() {
			return dmcl;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder setId(GenericIdentification175 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nm")
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder setNm(String _nm) {
			this.nm = _nm == null ? null : _nm;
			return this;
		}
		
		@RosettaAttribute("dmcl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dmcl")
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder setDmcl(String _dmcl) {
			this.dmcl = _dmcl == null ? null : _dmcl;
			return this;
		}
		
		@Override
		public NaturalPersonIdentification2 build() {
			return new NaturalPersonIdentification2.NaturalPersonIdentification2Impl(this);
		}
		
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getNm()!=null) return true;
			if (getDmcl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification2.NaturalPersonIdentification2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification2.NaturalPersonIdentification2Builder o = (NaturalPersonIdentification2.NaturalPersonIdentification2Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			merger.mergeBasic(getNm(), o.getNm(), this::setNm);
			merger.mergeBasic(getDmcl(), o.getDmcl(), this::setDmcl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification2 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(dmcl, _that.getDmcl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (dmcl != null ? dmcl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NaturalPersonIdentification2Builder {" +
				"id=" + this.id + ", " +
				"nm=" + this.nm + ", " +
				"dmcl=" + this.dmcl +
			'}';
		}
	}
}
