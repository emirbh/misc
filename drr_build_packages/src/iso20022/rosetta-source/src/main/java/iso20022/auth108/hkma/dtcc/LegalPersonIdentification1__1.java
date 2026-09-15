package iso20022.auth108.hkma.dtcc;

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
import iso20022.auth108.hkma.dtcc.meta.LegalPersonIdentification1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation which is a legal person.
 * @version ${project.version}
 */
@RosettaDataType(value="LegalPersonIdentification1__1", builder=LegalPersonIdentification1__1.LegalPersonIdentification1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="LegalPersonIdentification1__1", model="iso20022", builder=LegalPersonIdentification1__1.LegalPersonIdentification1__1BuilderImpl.class, version="${project.version}")
public interface LegalPersonIdentification1__1 extends RosettaModelObject {

	LegalPersonIdentification1__1Meta metaData = new LegalPersonIdentification1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique and unambiguous identification of the legal person.
	 */
	OrganisationIdentification15Choice__1 getId();

	/*********************** Build Methods  ***********************/
	LegalPersonIdentification1__1 build();
	
	LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder toBuilder();
	
	static LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder builder() {
		return new LegalPersonIdentification1__1.LegalPersonIdentification1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalPersonIdentification1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalPersonIdentification1__1> getType() {
		return LegalPersonIdentification1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, OrganisationIdentification15Choice__1.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalPersonIdentification1__1Builder extends LegalPersonIdentification1__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateId();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getId();
		LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder setId(OrganisationIdentification15Choice__1 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getId());
		}
		

		LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder prune();
	}

	/*********************** Immutable Implementation of LegalPersonIdentification1__1  ***********************/
	class LegalPersonIdentification1__1Impl implements LegalPersonIdentification1__1 {
		private final OrganisationIdentification15Choice__1 id;
		
		protected LegalPersonIdentification1__1Impl(LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public OrganisationIdentification15Choice__1 getId() {
			return id;
		}
		
		@Override
		public LegalPersonIdentification1__1 build() {
			return this;
		}
		
		@Override
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder toBuilder() {
			LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalPersonIdentification1__1 _that = getType().cast(o);
		
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
			return "LegalPersonIdentification1__1 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalPersonIdentification1__1  ***********************/
	class LegalPersonIdentification1__1BuilderImpl implements LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder {
	
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getId() {
			return id;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateId() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder setId(OrganisationIdentification15Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public LegalPersonIdentification1__1 build() {
			return new LegalPersonIdentification1__1.LegalPersonIdentification1__1Impl(this);
		}
		
		@Override
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder prune() {
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
		public LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder o = (LegalPersonIdentification1__1.LegalPersonIdentification1__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalPersonIdentification1__1 _that = getType().cast(o);
		
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
			return "LegalPersonIdentification1__1Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
