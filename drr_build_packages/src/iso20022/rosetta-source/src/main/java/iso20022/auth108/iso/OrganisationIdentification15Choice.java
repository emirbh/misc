package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.OrganisationIdentification15ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the identification of the organisation.
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification15Choice", builder=OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification15Choice", model="iso20022", builder=OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification15Choice extends RosettaModelObject {

	OrganisationIdentification15ChoiceMeta metaData = new OrganisationIdentification15ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification is done through the use of legal entity identifier code.
	 */
	String getLei();
	/**
	 * Unique identification of an organisation, using a client code or a business identification code.
	 */
	OrganisationIdentification38 getOthr();
	/**
	 * Business identifier code used to identify the organisation.
	 */
	String getAnyBIC();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification15Choice build();
	
	OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder toBuilder();
	
	static OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder builder() {
		return new OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification15Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification15Choice> getType() {
		return OrganisationIdentification15Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38.class, getOthr());
		processor.processBasic(path.newSubPath("anyBIC"), String.class, getAnyBIC(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification15ChoiceBuilder extends OrganisationIdentification15Choice, RosettaModelObjectBuilder {
		OrganisationIdentification38.OrganisationIdentification38Builder getOrCreateOthr();
		@Override
		OrganisationIdentification38.OrganisationIdentification38Builder getOthr();
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setLei(String lei);
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setOthr(OrganisationIdentification38 othr);
		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setAnyBIC(String anyBIC);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
			processRosetta(path.newSubPath("othr"), processor, OrganisationIdentification38.OrganisationIdentification38Builder.class, getOthr());
			processor.processBasic(path.newSubPath("anyBIC"), String.class, getAnyBIC(), this);
		}
		

		OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification15Choice  ***********************/
	class OrganisationIdentification15ChoiceImpl implements OrganisationIdentification15Choice {
		private final String lei;
		private final OrganisationIdentification38 othr;
		private final String anyBIC;
		
		protected OrganisationIdentification15ChoiceImpl(OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder builder) {
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
		public OrganisationIdentification38 getOthr() {
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
		public OrganisationIdentification15Choice build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder toBuilder() {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder builder) {
			ofNullable(getLei()).ifPresent(builder::setLei);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
			ofNullable(getAnyBIC()).ifPresent(builder::setAnyBIC);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice _that = getType().cast(o);
		
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
			return "OrganisationIdentification15Choice {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr + ", " +
				"anyBIC=" + this.anyBIC +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification15Choice  ***********************/
	class OrganisationIdentification15ChoiceBuilderImpl implements OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder {
	
		protected String lei;
		protected OrganisationIdentification38.OrganisationIdentification38Builder othr;
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
		public OrganisationIdentification38.OrganisationIdentification38Builder getOthr() {
			return othr;
		}
		
		@Override
		public OrganisationIdentification38.OrganisationIdentification38Builder getOrCreateOthr() {
			OrganisationIdentification38.OrganisationIdentification38Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = OrganisationIdentification38.builder();
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
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setOthr(OrganisationIdentification38 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("anyBIC")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyBIC")
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder setAnyBIC(String _anyBIC) {
			this.anyBIC = _anyBIC == null ? null : _anyBIC;
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice build() {
			return new OrganisationIdentification15Choice.OrganisationIdentification15ChoiceImpl(this);
		}
		
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder prune() {
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
		public OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder o = (OrganisationIdentification15Choice.OrganisationIdentification15ChoiceBuilder) other;
			
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			merger.mergeBasic(getAnyBIC(), o.getAnyBIC(), this::setAnyBIC);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice _that = getType().cast(o);
		
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
			return "OrganisationIdentification15ChoiceBuilder {" +
				"lei=" + this.lei + ", " +
				"othr=" + this.othr + ", " +
				"anyBIC=" + this.anyBIC +
			'}';
		}
	}
}
