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
import iso20022.auth030.hkma.dtcc.meta.OrganisationIdentification38__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies an organisation through client identification, a name and a domicile.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification38__3", builder=OrganisationIdentification38__3.OrganisationIdentification38__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification38__3", model="iso20022", builder=OrganisationIdentification38__3.OrganisationIdentification38__3BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification38__3 extends RosettaModelObject {

	OrganisationIdentification38__3Meta metaData = new OrganisationIdentification38__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the organisation.
	 */
	GenericIdentification175__3 getId();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification38__3 build();
	
	OrganisationIdentification38__3.OrganisationIdentification38__3Builder toBuilder();
	
	static OrganisationIdentification38__3.OrganisationIdentification38__3Builder builder() {
		return new OrganisationIdentification38__3.OrganisationIdentification38__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification38__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification38__3> getType() {
		return OrganisationIdentification38__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, GenericIdentification175__3.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification38__3Builder extends OrganisationIdentification38__3, RosettaModelObjectBuilder {
		GenericIdentification175__3.GenericIdentification175__3Builder getOrCreateId();
		@Override
		GenericIdentification175__3.GenericIdentification175__3Builder getId();
		OrganisationIdentification38__3.OrganisationIdentification38__3Builder setId(GenericIdentification175__3 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, GenericIdentification175__3.GenericIdentification175__3Builder.class, getId());
		}
		

		OrganisationIdentification38__3.OrganisationIdentification38__3Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification38__3  ***********************/
	class OrganisationIdentification38__3Impl implements OrganisationIdentification38__3 {
		private final GenericIdentification175__3 id;
		
		protected OrganisationIdentification38__3Impl(OrganisationIdentification38__3.OrganisationIdentification38__3Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__3 getId() {
			return id;
		}
		
		@Override
		public OrganisationIdentification38__3 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification38__3.OrganisationIdentification38__3Builder toBuilder() {
			OrganisationIdentification38__3.OrganisationIdentification38__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification38__3.OrganisationIdentification38__3Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__3 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__3 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification38__3  ***********************/
	class OrganisationIdentification38__3BuilderImpl implements OrganisationIdentification38__3.OrganisationIdentification38__3Builder {
	
		protected GenericIdentification175__3.GenericIdentification175__3Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public GenericIdentification175__3.GenericIdentification175__3Builder getId() {
			return id;
		}
		
		@Override
		public GenericIdentification175__3.GenericIdentification175__3Builder getOrCreateId() {
			GenericIdentification175__3.GenericIdentification175__3Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = GenericIdentification175__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public OrganisationIdentification38__3.OrganisationIdentification38__3Builder setId(GenericIdentification175__3 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public OrganisationIdentification38__3 build() {
			return new OrganisationIdentification38__3.OrganisationIdentification38__3Impl(this);
		}
		
		@Override
		public OrganisationIdentification38__3.OrganisationIdentification38__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification38__3.OrganisationIdentification38__3Builder prune() {
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
		public OrganisationIdentification38__3.OrganisationIdentification38__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification38__3.OrganisationIdentification38__3Builder o = (OrganisationIdentification38__3.OrganisationIdentification38__3Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification38__3 _that = getType().cast(o);
		
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
			return "OrganisationIdentification38__3Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
