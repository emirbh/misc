package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.OrganisationIdentification15Choice__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification15Choice__3", builder=OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification15Choice__3", model="iso20022", builder=OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification15Choice__3 extends RosettaModelObject {

	OrganisationIdentification15Choice__3Meta metaData = new OrganisationIdentification15Choice__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification is done through the use of legal entity identifier code.
	 */
	String getLei();
	/**
	 * Unique identification of an organisation, using a client code or a business identification code.
	 */
	OrganisationIdentification38__2 getOthr();
	/**
	 * Business identifier code used to identify the organisation.
	 */
	String getAnyBIC();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification15Choice__3 build();
	
	OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder toBuilder();
	
	static OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder builder() {
		return new OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification15Choice__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification15Choice__3> getType() {
		return OrganisationIdentification15Choice__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__2.class, getOthr());
		processor.processBasic(path.newSubPath("anyBIC"), String.class, getAnyBIC(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification15Choice__3Builder extends OrganisationIdentification15Choice__3, RosettaModelObjectBuilder {
		OrganisationIdentification38__2.OrganisationIdentification38__2Builder getOrCreateOthr();
		@Override
		OrganisationIdentification38__2.OrganisationIdentification38__2Builder getOthr();
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setLei(String lei);
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setOthr(OrganisationIdentification38__2 othr);
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setAnyBIC(String anyBIC);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
			processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38__2.OrganisationIdentification38__2Builder.class, getOthr());
			processor.processBasic(path.newSubPath("anyBIC"), String.class, getAnyBIC(), this);
		}
		

		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification15Choice__3  ***********************/
	class OrganisationIdentification15Choice__3Impl implements OrganisationIdentification15Choice__3 {
		private final String lei;
		private final OrganisationIdentification38__2 othr;
		private final String anyBIC;
		
		protected OrganisationIdentification15Choice__3Impl(OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder builder) {
			this.lei = builder.getLei();
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
			this.anyBIC = builder.getAnyBIC();
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
		public OrganisationIdentification38__2 getOthr() {
			return othr;
		}
		
		@Override
		@RosettaAttribute("anyBIC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyBIC")
		public String getAnyBIC() {
			return anyBIC;
		}
		
		@Override
		public OrganisationIdentification15Choice__3 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder toBuilder() {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder builder) {
			ofNullable(getLei()).ifPresent(builder::setLei);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
			ofNullable(getAnyBIC()).ifPresent(builder::setAnyBIC);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			if (!Objects.equals(anyBIC, _that.getAnyBIC())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			_result = 31 * _result + (anyBIC != null ? anyBIC.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__3 {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr + ", " +
				"anyBIC=" + this.anyBIC +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification15Choice__3  ***********************/
	class OrganisationIdentification15Choice__3BuilderImpl implements OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder {
	
		protected String lei;
		protected OrganisationIdentification38__2.OrganisationIdentification38__2Builder othr;
		protected String anyBIC;
		
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
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder getOthr() {
			return othr;
		}
		
		@Override
		public OrganisationIdentification38__2.OrganisationIdentification38__2Builder getOrCreateOthr() {
			OrganisationIdentification38__2.OrganisationIdentification38__2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = OrganisationIdentification38__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("anyBIC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyBIC")
		public String getAnyBIC() {
			return anyBIC;
		}
		
		@RosettaAttribute("lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lei")
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setOthr(OrganisationIdentification38__2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("anyBIC")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyBIC")
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder setAnyBIC(String _anyBIC) {
			this.anyBIC = _anyBIC == null ? null : _anyBIC;
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__3 build() {
			return new OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Impl(this);
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder prune() {
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLei()!=null) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			if (getAnyBIC()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder o = (OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder) other;
			
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			merger.mergeBasic(getAnyBIC(), o.getAnyBIC(), this::setAnyBIC);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__3 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			if (!Objects.equals(anyBIC, _that.getAnyBIC())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			_result = 31 * _result + (anyBIC != null ? anyBIC.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__3Builder {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr + ", " +
				"anyBIC=" + this.anyBIC +
			'}';
		}
	}
}
