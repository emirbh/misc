package iso20022.auth108.asic;

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
import iso20022.auth108.asic.meta.NaturalPersonIdentification3__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification3__1", builder=NaturalPersonIdentification3__1.NaturalPersonIdentification3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification3__1", model="iso20022", builder=NaturalPersonIdentification3__1.NaturalPersonIdentification3__1BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification3__1 extends RosettaModelObject {

	NaturalPersonIdentification3__1Meta metaData = new NaturalPersonIdentification3__1Meta();

	/*********************** Getter Methods  ***********************/
	NaturalPersonIdentification2__1 getId();

	/*********************** Build Methods  ***********************/
	NaturalPersonIdentification3__1 build();
	
	NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder toBuilder();
	
	static NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder builder() {
		return new NaturalPersonIdentification3__1.NaturalPersonIdentification3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPersonIdentification3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPersonIdentification3__1> getType() {
		return NaturalPersonIdentification3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification3__1Builder extends NaturalPersonIdentification3__1, RosettaModelObjectBuilder {
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateId();
		@Override
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getId();
		NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder setId(NaturalPersonIdentification2__1 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder.class, getId());
		}
		

		NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification3__1  ***********************/
	class NaturalPersonIdentification3__1Impl implements NaturalPersonIdentification3__1 {
		private final NaturalPersonIdentification2__1 id;
		
		protected NaturalPersonIdentification3__1Impl(NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
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
		public NaturalPersonIdentification3__1 build() {
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder toBuilder() {
			NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__1 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification3__1  ***********************/
	class NaturalPersonIdentification3__1BuilderImpl implements NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder {
	
		protected NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder id;
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder setId(NaturalPersonIdentification2__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__1 build() {
			return new NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Impl(this);
		}
		
		@Override
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder prune() {
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
		public NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder o = (NaturalPersonIdentification3__1.NaturalPersonIdentification3__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__1 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
