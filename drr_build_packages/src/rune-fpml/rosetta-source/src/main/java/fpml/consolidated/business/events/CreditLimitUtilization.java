package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CreditLimitUtilizationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CreditLimitUtilization", builder=CreditLimitUtilization.CreditLimitUtilizationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditLimitUtilization", model="fpml", builder=CreditLimitUtilization.CreditLimitUtilizationBuilderImpl.class, version="2.1.1")
public interface CreditLimitUtilization extends RosettaModelObject {

	CreditLimitUtilizationMeta metaData = new CreditLimitUtilizationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit limit utilization attributable to executed trades.
	 *
	 */
	CreditLimitUtilizationPosition getExecuted();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit limit utilization attributable to pending unexecuted orders.
	 *
	 */
	CreditLimitUtilizationPosition getPending();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilization build();
	
	CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder();
	
	static CreditLimitUtilization.CreditLimitUtilizationBuilder builder() {
		return new CreditLimitUtilization.CreditLimitUtilizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilization> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimitUtilization> getType() {
		return CreditLimitUtilization.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilizationPosition.class, getExecuted());
		processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilizationPosition.class, getPending());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilizationBuilder extends CreditLimitUtilization, RosettaModelObjectBuilder {
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreateExecuted();
		@Override
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getExecuted();
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreatePending();
		@Override
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getPending();
		CreditLimitUtilization.CreditLimitUtilizationBuilder setExecuted(CreditLimitUtilizationPosition executed);
		CreditLimitUtilization.CreditLimitUtilizationBuilder setPending(CreditLimitUtilizationPosition pending);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder.class, getExecuted());
			processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder.class, getPending());
		}
		

		CreditLimitUtilization.CreditLimitUtilizationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilization  ***********************/
	class CreditLimitUtilizationImpl implements CreditLimitUtilization {
		private final CreditLimitUtilizationPosition executed;
		private final CreditLimitUtilizationPosition pending;
		
		protected CreditLimitUtilizationImpl(CreditLimitUtilization.CreditLimitUtilizationBuilder builder) {
			this.executed = ofNullable(builder.getExecuted()).map(f->f.build()).orElse(null);
			this.pending = ofNullable(builder.getPending()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("executed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executed")
		public CreditLimitUtilizationPosition getExecuted() {
			return executed;
		}
		
		@Override
		@RosettaAttribute("pending")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pending")
		public CreditLimitUtilizationPosition getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilization build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder() {
			CreditLimitUtilization.CreditLimitUtilizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilization.CreditLimitUtilizationBuilder builder) {
			ofNullable(getExecuted()).ifPresent(builder::setExecuted);
			ofNullable(getPending()).ifPresent(builder::setPending);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilization _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilization {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilization  ***********************/
	class CreditLimitUtilizationBuilderImpl implements CreditLimitUtilization.CreditLimitUtilizationBuilder {
	
		protected CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder executed;
		protected CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder pending;
		
		@Override
		@RosettaAttribute("executed")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executed")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getExecuted() {
			return executed;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreateExecuted() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder result;
			if (executed!=null) {
				result = executed;
			}
			else {
				result = executed = CreditLimitUtilizationPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pending")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pending")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreatePending() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder result;
			if (pending!=null) {
				result = pending;
			}
			else {
				result = pending = CreditLimitUtilizationPosition.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("executed")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executed")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder setExecuted(CreditLimitUtilizationPosition _executed) {
			this.executed = _executed == null ? null : _executed.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pending")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pending")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder setPending(CreditLimitUtilizationPosition _pending) {
			this.pending = _pending == null ? null : _pending.toBuilder();
			return this;
		}
		
		@Override
		public CreditLimitUtilization build() {
			return new CreditLimitUtilization.CreditLimitUtilizationImpl(this);
		}
		
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder prune() {
			if (executed!=null && !executed.prune().hasData()) executed = null;
			if (pending!=null && !pending.prune().hasData()) pending = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecuted()!=null && getExecuted().hasData()) return true;
			if (getPending()!=null && getPending().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilization.CreditLimitUtilizationBuilder o = (CreditLimitUtilization.CreditLimitUtilizationBuilder) other;
			
			merger.mergeRosetta(getExecuted(), o.getExecuted(), this::setExecuted);
			merger.mergeRosetta(getPending(), o.getPending(), this::setPending);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilization _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationBuilder {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}
}
