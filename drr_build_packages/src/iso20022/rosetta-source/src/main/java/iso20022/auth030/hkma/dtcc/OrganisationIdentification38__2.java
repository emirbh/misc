package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.OrganisationIdentification38__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies an organisation through client identification, a name and a domicile.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification38__2", builder=OrganisationIdentification38__2.OrganisationIdentification38__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification38__2", model="iso20022", builder=OrganisationIdentification38__2.OrganisationIdentification38__2BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification38__2 extends RosettaModelObject {

	OrganisationIdentification38__2Meta metaData = new OrganisationIdentification38__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the organisation.
	 */
	GenericIdentification175__2 getId();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification38__2 build();
	
	OrganisationIdentification38__2.OrganisationIdentification38__2Builder toBuilder();
	
	static OrganisationIdentification38__2.OrganisationIdentification38__2Builder builder() {
		return new OrganisationIdentification38__2.OrganisationIdentification38__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification38__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification38__2> getType() {
		return OrganisationIdentification38__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, GenericIdentification175__2.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification38__2Builder extends OrganisationIdentification38__2, RosettaModelObjectBuilder {
		GenericIdentification175__2.GenericIdentification175__2Builder getOrCreateId();
		@Override
		GenericIdentification175__2.GenericIdentification175__2Builder getId();
		OrganisationIdentification38__2.OrganisationIdentification38__2Builder setId(GenericIdentification175__2 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, GenericIdentification175__2.GenericIdentification175__2Builder.class, getId());
		}
		

		OrganisationIdentification38__2.OrganisationIdentification38__2Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification38__2  ***********************/
	class OrganisationIdentification38__2Impl implements OrganisationIdentification38__2 {
		private final GenericIdentification175__2 id;
		
		protected OrganisationIdentification38__2Impl(OrganisationIdentification38__2.OrganisationIdentification38__2Builder builder) {
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
		public OrganisationIdentification38__2 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder toBuilder() {
			OrganisationIdentification38__2.OrganisationIdentification38__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification38__2.OrganisationIdentification38__2Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__2 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__2 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification38__2  ***********************/
	class OrganisationIdentification38__2BuilderImpl implements OrganisationIdentification38__2.OrganisationIdentification38__2Builder {
	
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
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder setId(GenericIdentification175__2 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public OrganisationIdentification38__2 build() {
			return new OrganisationIdentification38__2.OrganisationIdentification38__2Impl(this);
		}
		
		@Override
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder prune() {
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
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification38__2.OrganisationIdentification38__2Builder o = (OrganisationIdentification38__2.OrganisationIdentification38__2Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__2 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__2Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
