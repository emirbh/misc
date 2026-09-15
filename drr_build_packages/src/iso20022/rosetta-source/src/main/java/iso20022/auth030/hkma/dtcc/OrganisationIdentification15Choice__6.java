package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.hkma.dtcc.meta.OrganisationIdentification15Choice__6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification15Choice__6", builder=OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification15Choice__6", model="iso20022", builder=OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification15Choice__6 extends RosettaModelObject {

	OrganisationIdentification15Choice__6Meta metaData = new OrganisationIdentification15Choice__6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification is done through the use of legal entity identifier code.
	 */
	String getLei();
	/**
	 * Unique identification of an organisation, using a client code or a business identification code.
	 */
	OrganisationIdentification38__4 getOthr();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification15Choice__6 build();
	
	OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder toBuilder();
	
	static OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder builder() {
		return new OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification15Choice__6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification15Choice__6> getType() {
		return OrganisationIdentification15Choice__6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__4.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification15Choice__6Builder extends OrganisationIdentification15Choice__6, RosettaModelObjectBuilder {
		OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOrCreateOthr();
		@Override
		OrganisationIdentification38__4.OrganisationIdentification38__4Builder getOthr();
		OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder setLei(String lei);
		OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder setOthr(OrganisationIdentification38__4 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
			processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__4.OrganisationIdentification38__4Builder.class, getOthr());
		}
		

		OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification15Choice__6  ***********************/
	class OrganisationIdentification15Choice__6Impl implements OrganisationIdentification15Choice__6 {
		private final String lei;
		private final OrganisationIdentification38__4 othr;
		
		protected OrganisationIdentification15Choice__6Impl(OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder builder) {
			this.lei = builder.getLei();
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public OrganisationIdentification38__4 getOthr() {
			return othr;
		}
		
		@Override
		public OrganisationIdentification15Choice__6 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder toBuilder() {
			OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder builder) {
			ofNullable(getLei()).ifPresent(builder::setLei);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__6 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__6 {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification15Choice__6  ***********************/
	class OrganisationIdentification15Choice__6BuilderImpl implements OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder {
	
		protected String lei;
		protected OrganisationIdentification38__4.OrganisationIdentification38__4Builder othr;
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
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
		
		@RosettaAttribute("lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lei")
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder setOthr(OrganisationIdentification38__4 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__6 build() {
			return new OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Impl(this);
		}
		
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder prune() {
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLei()!=null) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder o = (OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder) other;
			
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__6 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__6Builder {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
