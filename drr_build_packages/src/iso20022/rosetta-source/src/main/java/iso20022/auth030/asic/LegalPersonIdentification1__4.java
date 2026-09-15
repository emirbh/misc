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
import iso20022.auth030.asic.meta.LegalPersonIdentification1__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LegalPersonIdentification1__4", builder=LegalPersonIdentification1__4.LegalPersonIdentification1__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="LegalPersonIdentification1__4", model="iso20022", builder=LegalPersonIdentification1__4.LegalPersonIdentification1__4BuilderImpl.class, version="${project.version}")
public interface LegalPersonIdentification1__4 extends RosettaModelObject {

	LegalPersonIdentification1__4Meta metaData = new LegalPersonIdentification1__4Meta();

	/*********************** Getter Methods  ***********************/
	OrganisationIdentification15Choice__2 getId();

	/*********************** Build Methods  ***********************/
	LegalPersonIdentification1__4 build();
	
	LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder toBuilder();
	
	static LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder builder() {
		return new LegalPersonIdentification1__4.LegalPersonIdentification1__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalPersonIdentification1__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalPersonIdentification1__4> getType() {
		return LegalPersonIdentification1__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, OrganisationIdentification15Choice__2.class, getId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalPersonIdentification1__4Builder extends LegalPersonIdentification1__4, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder getOrCreateId();
		@Override
		OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder getId();
		LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder setId(OrganisationIdentification15Choice__2 id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder.class, getId());
		}
		

		LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder prune();
	}

	/*********************** Immutable Implementation of LegalPersonIdentification1__4  ***********************/
	class LegalPersonIdentification1__4Impl implements LegalPersonIdentification1__4 {
		private final OrganisationIdentification15Choice__2 id;
		
		protected LegalPersonIdentification1__4Impl(LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public OrganisationIdentification15Choice__2 getId() {
			return id;
		}
		
		@Override
		public LegalPersonIdentification1__4 build() {
			return this;
		}
		
		@Override
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder toBuilder() {
			LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalPersonIdentification1__4 _that = getType().cast(o);
		
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
			return "LegalPersonIdentification1__4 {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalPersonIdentification1__4  ***********************/
	class LegalPersonIdentification1__4BuilderImpl implements LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder {
	
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder getId() {
			return id;
		}
		
		@Override
		public OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder getOrCreateId() {
			OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = OrganisationIdentification15Choice__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder setId(OrganisationIdentification15Choice__2 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public LegalPersonIdentification1__4 build() {
			return new LegalPersonIdentification1__4.LegalPersonIdentification1__4Impl(this);
		}
		
		@Override
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder prune() {
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
		public LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder o = (LegalPersonIdentification1__4.LegalPersonIdentification1__4Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalPersonIdentification1__4 _that = getType().cast(o);
		
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
			return "LegalPersonIdentification1__4Builder {" +
				"id=" + this.id +
			'}';
		}
	}
}
