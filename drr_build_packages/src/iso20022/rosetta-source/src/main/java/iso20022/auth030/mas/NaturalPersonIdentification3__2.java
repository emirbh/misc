package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.NaturalPersonIdentification3__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification3__2", builder=NaturalPersonIdentification3__2.NaturalPersonIdentification3__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification3__2", model="iso20022", builder=NaturalPersonIdentification3__2.NaturalPersonIdentification3__2BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification3__2 extends RosettaModelObject {

	NaturalPersonIdentification3__2Meta metaData = new NaturalPersonIdentification3__2Meta();

	/*********************** Getter Methods  ***********************/
	NaturalPersonIdentification2__2 getId();

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
		processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__2.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification3__2Builder extends NaturalPersonIdentification3__2, RosettaModelObjectBuilder {
		NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder getOrCreateId();
		@Override
		NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder getId();
		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setId(NaturalPersonIdentification2__2 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder.class, getId());
		}
		

		NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification3__2  ***********************/
	class NaturalPersonIdentification3__2Impl implements NaturalPersonIdentification3__2 {
		private final NaturalPersonIdentification2__2 id;
		
		protected NaturalPersonIdentification3__2Impl(NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public NaturalPersonIdentification2__2 getId() {
			return id;
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
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__2 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__2 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification3__2  ***********************/
	class NaturalPersonIdentification3__2BuilderImpl implements NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder {
	
		protected NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder getId() {
			return id;
		}
		
		@Override
		public NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder getOrCreateId() {
			NaturalPersonIdentification2__2.NaturalPersonIdentification2__2Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = NaturalPersonIdentification2__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder setId(NaturalPersonIdentification2__2 _id) {
			this.id = _id == null ? null : _id.toBuilder();
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
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder o = (NaturalPersonIdentification3__2.NaturalPersonIdentification3__2Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__2 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__2Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
