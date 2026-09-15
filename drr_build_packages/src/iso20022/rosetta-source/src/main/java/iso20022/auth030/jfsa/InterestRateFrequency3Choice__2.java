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
import iso20022.auth030.jfsa.meta.InterestRateFrequency3Choice__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateFrequency3Choice__2", builder=InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRateFrequency3Choice__2", model="iso20022", builder=InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2BuilderImpl.class, version="${project.version}")
public interface InterestRateFrequency3Choice__2 extends RosettaModelObject {

	InterestRateFrequency3Choice__2Meta metaData = new InterestRateFrequency3Choice__2Meta();

	/*********************** Getter Methods  ***********************/
	InterestRateContractTerm4 getTerm();

	/*********************** Build Methods  ***********************/
	InterestRateFrequency3Choice__2 build();
	
	InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder toBuilder();
	
	static InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder builder() {
		return new InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateFrequency3Choice__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateFrequency3Choice__2> getType() {
		return InterestRateFrequency3Choice__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, InterestRateContractTerm4.class, getTerm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateFrequency3Choice__2Builder extends InterestRateFrequency3Choice__2, RosettaModelObjectBuilder {
		InterestRateContractTerm4.InterestRateContractTerm4Builder getOrCreateTerm();
		@Override
		InterestRateContractTerm4.InterestRateContractTerm4Builder getTerm();
		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder setTerm(InterestRateContractTerm4 term);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, InterestRateContractTerm4.InterestRateContractTerm4Builder.class, getTerm());
		}
		

		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder prune();
	}

	/*********************** Immutable Implementation of InterestRateFrequency3Choice__2  ***********************/
	class InterestRateFrequency3Choice__2Impl implements InterestRateFrequency3Choice__2 {
		private final InterestRateContractTerm4 term;
		
		protected InterestRateFrequency3Choice__2Impl(InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public InterestRateContractTerm4 getTerm() {
			return term;
		}
		
		@Override
		public InterestRateFrequency3Choice__2 build() {
			return this;
		}
		
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder toBuilder() {
			InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateFrequency3Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateFrequency3Choice__2 {" +
				"term=" + this.term +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateFrequency3Choice__2  ***********************/
	class InterestRateFrequency3Choice__2BuilderImpl implements InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder {
	
		protected InterestRateContractTerm4.InterestRateContractTerm4Builder term;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public InterestRateContractTerm4.InterestRateContractTerm4Builder getTerm() {
			return term;
		}
		
		@Override
		public InterestRateContractTerm4.InterestRateContractTerm4Builder getOrCreateTerm() {
			InterestRateContractTerm4.InterestRateContractTerm4Builder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = InterestRateContractTerm4.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("term")
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder setTerm(InterestRateContractTerm4 _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateFrequency3Choice__2 build() {
			return new InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Impl(this);
		}
		
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder o = (InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateFrequency3Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateFrequency3Choice__2Builder {" +
				"term=" + this.term +
			'}';
		}
	}
}
