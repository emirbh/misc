package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.InterestRateFrequency3Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes frequency of payments for interest rates, either using term notation or a proprietary notation.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestRateFrequency3Choice__1", builder=InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestRateFrequency3Choice__1", model="iso20022", builder=InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1BuilderImpl.class, version="${project.version}")
public interface InterestRateFrequency3Choice__1 extends RosettaModelObject {

	InterestRateFrequency3Choice__1Meta metaData = new InterestRateFrequency3Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Frequency expressed in tenor notation.
	 */
	InterestRateContractTerm4__1 getTerm();

	/*********************** Build Methods  ***********************/
	InterestRateFrequency3Choice__1 build();
	
	InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder toBuilder();
	
	static InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder builder() {
		return new InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateFrequency3Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestRateFrequency3Choice__1> getType() {
		return InterestRateFrequency3Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, InterestRateContractTerm4__1.class, getTerm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateFrequency3Choice__1Builder extends InterestRateFrequency3Choice__1, RosettaModelObjectBuilder {
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getOrCreateTerm();
		@Override
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getTerm();
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder setTerm(InterestRateContractTerm4__1 term);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder.class, getTerm());
		}
		

		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of InterestRateFrequency3Choice__1  ***********************/
	class InterestRateFrequency3Choice__1Impl implements InterestRateFrequency3Choice__1 {
		private final InterestRateContractTerm4__1 term;
		
		protected InterestRateFrequency3Choice__1Impl(InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public InterestRateContractTerm4__1 getTerm() {
			return term;
		}
		
		@Override
		public InterestRateFrequency3Choice__1 build() {
			return this;
		}
		
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder toBuilder() {
			InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateFrequency3Choice__1 _that = getType().cast(o);
		
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
			return "InterestRateFrequency3Choice__1 {" +
				"term=" + this.term +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestRateFrequency3Choice__1  ***********************/
	class InterestRateFrequency3Choice__1BuilderImpl implements InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder {
	
		protected InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder term;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getTerm() {
			return term;
		}
		
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getOrCreateTerm() {
			InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = InterestRateContractTerm4__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("term")
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder setTerm(InterestRateContractTerm4__1 _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateFrequency3Choice__1 build() {
			return new InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Impl(this);
		}
		
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder prune() {
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
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder o = (InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestRateFrequency3Choice__1 _that = getType().cast(o);
		
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
			return "InterestRateFrequency3Choice__1Builder {" +
				"term=" + this.term +
			'}';
		}
	}
}
