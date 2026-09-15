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
import iso20022.auth030.asic.meta.QuantityOrTerm1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="QuantityOrTerm1Choice__1", builder=QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="QuantityOrTerm1Choice__1", model="iso20022", builder=QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl.class, version="${project.version}")
public interface QuantityOrTerm1Choice__1 extends RosettaModelObject {

	QuantityOrTerm1Choice__1Meta metaData = new QuantityOrTerm1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	QuantityTerm1__1 getTerm();

	/*********************** Build Methods  ***********************/
	QuantityOrTerm1Choice__1 build();
	
	QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder();
	
	static QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder() {
		return new QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityOrTerm1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QuantityOrTerm1Choice__1> getType() {
		return QuantityOrTerm1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, QuantityTerm1__1.class, getTerm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityOrTerm1Choice__1Builder extends QuantityOrTerm1Choice__1, RosettaModelObjectBuilder {
		QuantityTerm1__1.QuantityTerm1__1Builder getOrCreateTerm();
		@Override
		QuantityTerm1__1.QuantityTerm1__1Builder getTerm();
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder setTerm(QuantityTerm1__1 term);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, QuantityTerm1__1.QuantityTerm1__1Builder.class, getTerm());
		}
		

		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of QuantityOrTerm1Choice__1  ***********************/
	class QuantityOrTerm1Choice__1Impl implements QuantityOrTerm1Choice__1 {
		private final QuantityTerm1__1 term;
		
		protected QuantityOrTerm1Choice__1Impl(QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public QuantityTerm1__1 getTerm() {
			return term;
		}
		
		@Override
		public QuantityOrTerm1Choice__1 build() {
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder() {
			QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityOrTerm1Choice__1 _that = getType().cast(o);
		
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
			return "QuantityOrTerm1Choice__1 {" +
				"term=" + this.term +
			'}';
		}
	}

	/*********************** Builder Implementation of QuantityOrTerm1Choice__1  ***********************/
	class QuantityOrTerm1Choice__1BuilderImpl implements QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder {
	
		protected QuantityTerm1__1.QuantityTerm1__1Builder term;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("term")
		public QuantityTerm1__1.QuantityTerm1__1Builder getTerm() {
			return term;
		}
		
		@Override
		public QuantityTerm1__1.QuantityTerm1__1Builder getOrCreateTerm() {
			QuantityTerm1__1.QuantityTerm1__1Builder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = QuantityTerm1__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("term")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder setTerm(QuantityTerm1__1 _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@Override
		public QuantityOrTerm1Choice__1 build() {
			return new QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Impl(this);
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder prune() {
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
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder o = (QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuantityOrTerm1Choice__1 _that = getType().cast(o);
		
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
			return "QuantityOrTerm1Choice__1Builder {" +
				"term=" + this.term +
			'}';
		}
	}
}
