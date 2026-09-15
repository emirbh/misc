package iso20022.auth108.mas;

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
import iso20022.auth108.mas.meta.OrganisationIdentification15Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OrganisationIdentification15Choice__1", builder=OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OrganisationIdentification15Choice__1", model="iso20022", builder=OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1BuilderImpl.class, version="${project.version}")
public interface OrganisationIdentification15Choice__1 extends RosettaModelObject {

	OrganisationIdentification15Choice__1Meta metaData = new OrganisationIdentification15Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	String getLei();

	/*********************** Build Methods  ***********************/
	OrganisationIdentification15Choice__1 build();
	
	OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder toBuilder();
	
	static OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder builder() {
		return new OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrganisationIdentification15Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrganisationIdentification15Choice__1> getType() {
		return OrganisationIdentification15Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrganisationIdentification15Choice__1Builder extends OrganisationIdentification15Choice__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder setLei(String lei);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		}
		

		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of OrganisationIdentification15Choice__1  ***********************/
	class OrganisationIdentification15Choice__1Impl implements OrganisationIdentification15Choice__1 {
		private final String lei;
		
		protected OrganisationIdentification15Choice__1Impl(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder builder) {
			this.lei = builder.getLei();
		}
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		public OrganisationIdentification15Choice__1 build() {
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder toBuilder() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder builder) {
			ofNullable(getLei()).ifPresent(builder::setLei);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__1 {" +
				"lei=" + this.lei +
			'}';
		}
	}

	/*********************** Builder Implementation of OrganisationIdentification15Choice__1  ***********************/
	class OrganisationIdentification15Choice__1BuilderImpl implements OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder {
	
		protected String lei;
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@RosettaAttribute("lei")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lei")
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@Override
		public OrganisationIdentification15Choice__1 build() {
			return new OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Impl(this);
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLei()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder o = (OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder) other;
			
			
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrganisationIdentification15Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrganisationIdentification15Choice__1Builder {" +
				"lei=" + this.lei +
			'}';
		}
	}
}
