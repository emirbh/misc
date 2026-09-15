package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.NaturalPersonIdentification3__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NaturalPersonIdentification3__3", builder=NaturalPersonIdentification3__3.NaturalPersonIdentification3__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NaturalPersonIdentification3__3", model="iso20022", builder=NaturalPersonIdentification3__3.NaturalPersonIdentification3__3BuilderImpl.class, version="${project.version}")
public interface NaturalPersonIdentification3__3 extends RosettaModelObject {

	NaturalPersonIdentification3__3Meta metaData = new NaturalPersonIdentification3__3Meta();

	/*********************** Getter Methods  ***********************/
	NaturalPersonIdentification2__1 getId();

	/*********************** Build Methods  ***********************/
	NaturalPersonIdentification3__3 build();
	
	NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder toBuilder();
	
	static NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder builder() {
		return new NaturalPersonIdentification3__3.NaturalPersonIdentification3__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NaturalPersonIdentification3__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NaturalPersonIdentification3__3> getType() {
		return NaturalPersonIdentification3__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NaturalPersonIdentification3__3Builder extends NaturalPersonIdentification3__3, RosettaModelObjectBuilder {
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getOrCreateId();
		@Override
		NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder getId();
		NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder setId(NaturalPersonIdentification2__1 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, NaturalPersonIdentification2__1.NaturalPersonIdentification2__1Builder.class, getId());
		}
		

		NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder prune();
	}

	/*********************** Immutable Implementation of NaturalPersonIdentification3__3  ***********************/
	class NaturalPersonIdentification3__3Impl implements NaturalPersonIdentification3__3 {
		private final NaturalPersonIdentification2__1 id;
		
		protected NaturalPersonIdentification3__3Impl(NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder builder) {
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
		public NaturalPersonIdentification3__3 build() {
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder toBuilder() {
			NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__3 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__3 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of NaturalPersonIdentification3__3  ***********************/
	class NaturalPersonIdentification3__3BuilderImpl implements NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder {
	
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
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder setId(NaturalPersonIdentification2__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public NaturalPersonIdentification3__3 build() {
			return new NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Impl(this);
		}
		
		@Override
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder prune() {
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
		public NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder o = (NaturalPersonIdentification3__3.NaturalPersonIdentification3__3Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NaturalPersonIdentification3__3 _that = getType().cast(o);
		
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
			return "NaturalPersonIdentification3__3Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
