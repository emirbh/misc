package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.OrganisationIdentification15Choice__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification15Choice__5", builder=OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification15Choice__5", model="iso20022", builder=OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification15Choice__5 extends RosettaModelObject {

	OrganisationIdentification15Choice__5Meta metaData = new OrganisationIdentification15Choice__5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identification of an organisation, using a client code or a business identification code.
	 */
	OrganisationIdentification38__4 getOthr();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification15Choice__5 build();
	
	OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder toBuilder();
	
	static OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder builder() {
		return new OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification15Choice__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification15Choice__5> getType() {
		return OrganisationIdentification15Choice__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__4.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification15Choice__5Builder extends OrganisationIdentification15Choice__5, RosettaModelObjectBuilder {
		OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOrCreateOthr();
		@Override
		OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOthr();
		OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder setOthr(OrganisationIdentification38__4 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__4.OrganisationIdentification38__4Builder.class, getOthr());
		}
		

		OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification15Choice__5  ***********************/
	class OrganisationIdentification15Choice__5Impl implements OrganisationIdentification15Choice__5 {
		private final OrganisationIdentification38__4 othr;
		
		protected OrganisationIdentification15Choice__5Impl(OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder builder) {
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othr")
		public OrganisationIdentification38__4 getOthr() {
			return othr;
		}
		
		@Override
		public OrganisationIdentification15Choice__5 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder toBuilder() {
			OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder builder) {
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__5 _that = getType().cast(o);
		
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__5 {" +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification15Choice__5  ***********************/
	class OrganisationIdentification15Choice__5BuilderImpl implements OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder {
	
		protected OrganisationIdentification38__4.OrganisationIdentification38__4Builder othr;
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("othr")
		public OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOthr() {
			return othr;
		}
		
		@Override
		public OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOrCreateOthr() {
			OrganisationIdentification38__4.OrganisationIdentification38__4Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = OrganisationIdentification38__4.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("othr")
		@Override
		public OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder setOthr(OrganisationIdentification38__4 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__5 build() {
			return new OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Impl(this);
		}
		
		@Override
		public OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder prune() {
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder o = (OrganisationIdentification15Choice__5.OrganisationIdentification15Choice__5Builder) other;
			
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__5 _that = getType().cast(o);
		
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__5Builder {" +
				"othr=" + this.othr +
			'}';
		}
	}
}
