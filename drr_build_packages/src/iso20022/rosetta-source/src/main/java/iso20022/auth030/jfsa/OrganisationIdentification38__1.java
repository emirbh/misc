package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.OrganisationIdentification38__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification38__1", builder=OrganisationIdentification38__1.OrganisationIdentification38__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification38__1", model="iso20022", builder=OrganisationIdentification38__1.OrganisationIdentification38__1BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification38__1 extends RosettaModelObject {

	OrganisationIdentification38__1Meta metaData = new OrganisationIdentification38__1Meta();

	/*********************** Getter Methods  ***********************/
	GenericIdentification175__1 getId();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification38__1 build();
	
	OrganisationIdentification38__1.OrganisationIdentification38__1Builder toBuilder();
	
	static OrganisationIdentification38__1.OrganisationIdentification38__1Builder builder() {
		return new OrganisationIdentification38__1.OrganisationIdentification38__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification38__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification38__1> getType() {
		return OrganisationIdentification38__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, GenericIdentification175__1.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification38__1Builder extends OrganisationIdentification38__1, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateId();
		@Override
		GenericIdentification175__1.GenericIdentification175__1Builder getId();
		OrganisationIdentification38__1.OrganisationIdentification38__1Builder setId(GenericIdentification175__1 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, GenericIdentification175__1.GenericIdentification175__1Builder.class, getId());
		}
		

		OrganisationIdentification38__1.OrganisationIdentification38__1Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification38__1  ***********************/
	class OrganisationIdentification38__1Impl implements OrganisationIdentification38__1 {
		private final GenericIdentification175__1 id;
		
		protected OrganisationIdentification38__1Impl(OrganisationIdentification38__1.OrganisationIdentification38__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__1 getId() {
			return id;
		}
		
		@Override
		public OrganisationIdentification38__1 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification38__1.OrganisationIdentification38__1Builder toBuilder() {
			OrganisationIdentification38__1.OrganisationIdentification38__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification38__1.OrganisationIdentification38__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__1 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification38__1  ***********************/
	class OrganisationIdentification38__1BuilderImpl implements OrganisationIdentification38__1.OrganisationIdentification38__1Builder {
	
		protected GenericIdentification175__1.GenericIdentification175__1Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__1.GenericIdentification175__1Builder getId() {
			return id;
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateId() {
			GenericIdentification175__1.GenericIdentification175__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = GenericIdentification175__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public OrganisationIdentification38__1.OrganisationIdentification38__1Builder setId(GenericIdentification175__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public OrganisationIdentification38__1 build() {
			return new OrganisationIdentification38__1.OrganisationIdentification38__1Impl(this);
		}
		
		@Override
		public OrganisationIdentification38__1.OrganisationIdentification38__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification38__1.OrganisationIdentification38__1Builder prune() {
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
		public OrganisationIdentification38__1.OrganisationIdentification38__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification38__1.OrganisationIdentification38__1Builder o = (OrganisationIdentification38__1.OrganisationIdentification38__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__1 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
